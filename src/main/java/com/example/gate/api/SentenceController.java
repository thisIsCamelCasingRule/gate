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
@RequestMapping(path = "/sentence")
public class SentenceController {

    private final String url = "http://demo-serv.herokuapp.com/sentence";

    @GetMapping(params = {"peasant", "kingdom"})
    public Boolean executePeasant(@RequestParam String peasant, @RequestParam String kingdom)
    {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).
                queryParam("peasant", peasant).
                queryParam("kingdom", kingdom);
        ResponseEntity<Boolean> result =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, Boolean.class);
        return result.getBody();
    }

    @GetMapping(params = {"peasant"})
    public Boolean pardonPeasant(@RequestParam String peasant)
    {
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).
                queryParam("peasant", peasant);
        ResponseEntity<Boolean> result =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, Boolean.class);
        return result.getBody();
    }

}
