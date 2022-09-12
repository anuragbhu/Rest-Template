package com.example.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/gitHub/users/{login}")
    public ResponseEntity<GitHubUser> getUsers(@PathVariable("login") String login){
        ResponseEntity<GitHubUser> response = restTemplate.getForEntity(
                String.format("https://api.github.com/users/%s", login), GitHubUser.class);
        System.out.println(response.getHeaders());
        System.out.println(response.getStatusCode());
        GitHubUser gitHubUser = response.getBody();
        System.out.println(gitHubUser.toString());
        return response;
    }

    @GetMapping("/template/endPoint")
    public String endPoint() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://localhost:8081/hi",
                HttpMethod.GET, entity, String.class).getBody();
    }
}
