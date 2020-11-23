package com.example.gate.api;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(path = "/war")
public class WarController {

    private final String url = "http://demo-serv.herokuapp.com/war";

    @GetMapping
    public Boolean war(@RequestParam String kingdom1, @RequestParam String kingdom2)
    {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).
                queryParam("kingdom1", kingdom1).
                queryParam("kingdom2", kingdom2);
        ResponseEntity<Boolean> result =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, Boolean.class);
        return result.getBody();
    }
}
