package com.starwars.api.service;


import com.starwars.api.dto.PlanetDTO;
import com.starwars.api.dto.SwapiDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class SwapiService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String url = "https://swapi.dev/api/planets/";


    public SwapiDTO getApparitionQuantity(String name) {
        SwapiDTO swapiDTO = restTemplate.getForObject(url+"?search=" + name, SwapiDTO.class);
        return swapiDTO;
    }
    public List<PlanetDTO> getAllPlanets() {
        SwapiDTO swapiDTO = restTemplate.getForObject(url, SwapiDTO.class);
        List<PlanetDTO> planetList = new ArrayList<>();
        swapiDTO.getResults().forEach((result)-> {
            PlanetDTO planet = new PlanetDTO(result.getName(),result.getClimate(),result.getTerrain(), result.getFilms().size());
            planetList.add(planet);
        });
        return planetList;
    }
}
