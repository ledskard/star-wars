package com.starwars.api.controller;

import com.starwars.api.dto.PlanetDTO;
import com.starwars.api.model.Planet;
import com.starwars.api.service.PlanetService;
import com.starwars.api.service.SwapiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    @Autowired
    private PlanetService planetService;
    @Autowired
    private SwapiService swapiService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Planet planet){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(planetService.create(planet)).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/all")
    public ResponseEntity<Object> findAllPlanetsBySwapi(){
        List<PlanetDTO> planets= swapiService.getAllPlanets();
        return ResponseEntity.ok(planets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> findById(@PathVariable("id") Long id){
        Planet planet = planetService.findById(id);
        return ResponseEntity.ok(planet);
    }

    @GetMapping("/name")
    public ResponseEntity<Planet> findByName(@RequestParam("name") String name){
        Planet planet = planetService.findByName(name);
        return ResponseEntity.ok(planet);
    }

    @GetMapping
    public ResponseEntity<List<Planet>> findAll(){
        List<Planet> planet = planetService.findAll();
        return ResponseEntity.ok(planet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Planet>> delete(@PathVariable("id") Long id){
        planetService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
