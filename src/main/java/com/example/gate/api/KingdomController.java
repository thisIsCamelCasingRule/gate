package com.example.gate.api;


import com.example.gate.data.Kingdom;
import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/kingdom")
@NoArgsConstructor
public class KingdomController {

    private final String url = "http://localhost:8082/kingdom";

    @PostMapping
    public Kingdom addNewKingdom(@RequestParam String name,
                                                 @RequestParam double sqare,
                                                 @RequestParam int population,
                                                 @RequestParam int amountOfBuildings){
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).
                queryParam("name", name).
                queryParam("sqare", sqare).
                queryParam("population", population).
                queryParam("amountOfBuildings", amountOfBuildings);
        ResponseEntity<Kingdom> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, Kingdom.class);
        System.out.println(response.getBody());
        return response.getBody();
    }

    @GetMapping
    public List<Kingdom> getAllKingdom()
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Kingdom>> result =
                restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });
        return result.getBody();
    }

    @GetMapping(params = {"name"})
    public Kingdom getKingdomByName(@RequestParam String name){
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).
                queryParam("name", name);
        ResponseEntity<Kingdom> result =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, Kingdom.class);
        return result.getBody();
    }

    @PutMapping(params= {"name"})
    public Kingdom updateKingdom(@RequestParam String name,
                                                 @RequestParam double sqare,
                                                 @RequestParam int population,
                                                 @RequestParam int amountOfBuildings){

        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).
                queryParam("name", name).
                queryParam("sqare", sqare).
                queryParam("population", population).
                queryParam("amountOfBuildings", amountOfBuildings);
        ResponseEntity<Kingdom> result =
                restTemplate.exchange(builder.toUriString(), HttpMethod.PUT, null, Kingdom.class);
        return result.getBody();
    }

    @DeleteMapping(params= {"name"})
    public Boolean deleteKingdom(@RequestParam String name){
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).
                queryParam("name", name);
        ResponseEntity<Boolean> result =
                restTemplate.exchange(builder.toUriString(), HttpMethod.DELETE, null, Boolean.class);
        return result.getBody();
    }

    @DeleteMapping
    public Boolean deleteAllKingdoms(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Boolean> result =
                restTemplate.exchange(url, HttpMethod.DELETE, null, Boolean.class);
        return result.getBody();
    }

}
