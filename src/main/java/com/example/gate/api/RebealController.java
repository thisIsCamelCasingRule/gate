package com.example.gate.api;

import com.example.gate.data.Peasant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(path = "/rebeal")
public class RebealController {

    private final String url = "http://demo-serv.herokuapp.com/rebeal";

    @GetMapping
    public Boolean rebeal(@RequestParam String oldKing, @RequestParam String newKing)
    {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).
                queryParam("oldKing", oldKing).
                queryParam("newKing", newKing);
        ResponseEntity<Boolean> result =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, Boolean.class);
        return result.getBody();
    }

}
