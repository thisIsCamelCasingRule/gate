package com.example.gate.api;

import com.example.gate.data.Kingdom;
import com.example.gate.data.Peasant;

import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/peasant")
@NoArgsConstructor
public class PeasantController {

    private final String url = "http://peasant-service.herokuapp.com/peasant";

    @PostMapping
    public Peasant addNewPeasant(@RequestParam String name,
                                                 @RequestParam String position,
                                                 @RequestParam String kingdom,
                                                 @RequestParam boolean status){

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).
                queryParam("name", name).
                queryParam("position", position).
                queryParam("kingdom", kingdom).
                queryParam("status", status);
        ResponseEntity<Peasant> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, Peasant.class);
        System.out.println(response.getBody());
        return response.getBody();
    }

    @GetMapping
    public List<Peasant> getAllPeasant()
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Peasant>> result =
                restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Peasant>>() {
                });
        return result.getBody();
    }

    @GetMapping(params= {"name"})
    public Peasant getPeasantByName(@RequestParam String name){
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).
                queryParam("name", name);
        ResponseEntity<Peasant> result =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, Peasant.class);
        return result.getBody();
    }

    @PutMapping(params= {"name"})
    public Peasant updatePeasant(@RequestParam String name,
                                                 @RequestParam String position,
                                                 @RequestParam String kingdom,
                                                 @RequestParam boolean status){
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).
                queryParam("name", name).
                queryParam("position", position).
                queryParam("kingdom", kingdom).
                queryParam("status", status);
        ResponseEntity<Peasant> result =
                restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, null, Peasant.class);
        return result.getBody();
    }

    @DeleteMapping(params= {"name"})
    public Boolean deletePeasant(@RequestParam String name){
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).
                queryParam("name", name);
        ResponseEntity<Boolean> result =
                restTemplate.exchange(builder.toUriString(), HttpMethod.DELETE, null, Boolean.class);
        return result.getBody();
    }

    @DeleteMapping
    public Boolean deleteAllPeasant(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Boolean> result =
                restTemplate.exchange(url, HttpMethod.DELETE, null, Boolean.class);
        return result.getBody();
    }
}
