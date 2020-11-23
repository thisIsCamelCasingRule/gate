package com.example.gate.api;

import com.example.gate.data.King;
import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/king")
@NoArgsConstructor
public class KingController {

    private final String url = "http://king-service.herokuapp.com/king";

    @PostMapping(params = {"name", "kingdom"})
    public King addNewKing(@RequestParam String name, @RequestParam String kingdom){
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).
                queryParam("name", name).
                queryParam("kingdom", kingdom);
        ResponseEntity<King> result =
                restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, King.class);
        return result.getBody();
    }

    @GetMapping
    public List<King> getAllKing() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<King>> result =
                restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<King>>() {
                });
        return result.getBody();
    }

    @GetMapping(params = {"name"})
    public King getKingByName(@RequestParam String name){
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).
                queryParam("name", name);
        ResponseEntity<King> result =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, King.class);
        return result.getBody();
    }

    @PutMapping(params = {"name"})
    public King updateKing(@RequestParam String name, @RequestParam String kingdom){
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).
                queryParam("name", name).
                queryParam("kingdom", kingdom);
        ResponseEntity<King> result =
                restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, King.class);
        return result.getBody();
    }

    @DeleteMapping(params= {"name"})
    public Boolean deleteKing(@RequestParam String name){
        RestTemplate restTemplate = new RestTemplate();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).
                queryParam("name", name);
        ResponseEntity<Boolean> result =
                restTemplate.exchange(builder.toUriString(), HttpMethod.DELETE, null, Boolean.class);
        return result.getBody();
    }

    @DeleteMapping
    public Boolean deleteAllKing(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Boolean> result =
                restTemplate.exchange(url, HttpMethod.DELETE, null, Boolean.class);
        return result.getBody();
    }
}
