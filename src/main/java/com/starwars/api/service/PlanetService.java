package com.starwars.api.service;

import com.starwars.api.dto.SwapiDTO;
import com.starwars.api.exception.ObjectNotFoundException;
import com.starwars.api.model.Planet;
import com.starwars.api.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private SwapiService swapiService;

    public Planet create(Planet planet){
        SwapiDTO swapiDTO = swapiService.getApparitionQuantity(planet.getName());
        if(swapiDTO.getResults().toArray().length > 0){
            List<String> filmsApparition = swapiDTO.resultDTO.get(0).getFilms();
            planet.setApparitionQuantity(filmsApparition.size());
        } else {
            planet.setApparitionQuantity(0);
        }
        return planetRepository.save(planet);
    }

    public List<Planet> findAll(){
       return planetRepository.findAll();
    }

    public Planet findByName(String name){
       return planetRepository.findByName(name).orElseThrow(() -> new ObjectNotFoundException("Name not found"));
    }
    public Planet findById(Long id){
       return planetRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Id not found"));
    }
    public void delete(Long id){
        planetRepository.deleteById(id);
    }
}
