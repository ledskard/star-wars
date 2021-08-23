package com.starwars.api.service;

import com.starwars.api.dto.ResultDTO;
import com.starwars.api.dto.SwapiDTO;
import com.starwars.api.model.Planet;
import com.starwars.api.repository.PlanetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;


@RunWith(SpringRunner.class)
public class PlanetServiceTest {
    @TestConfiguration
    static class PlanetServiceTestConfiguration {
        @Bean
        public PlanetService planetService(){
            return new PlanetService();
        }
    }

    @Autowired
    private PlanetService planetService;

    @MockBean
    private PlanetRepository planetRepository;

    @MockBean
    private SwapiService swapiService;

    @Test
    public void create(){
        Planet planetDataMock = new Planet( 1L,"Hoth", "frozen", "tundra, ice caves, mountain ranges", 1);
        List<String> apparitionList = new ArrayList<>();
        SwapiDTO swapiDataMock = new SwapiDTO();
        List<ResultDTO> resultList = new ArrayList<>();
        apparitionList.add("https://swapi.dev/api/films/3/");
        apparitionList.add("https://swapi.dev/api/films/2/");
        ResultDTO resultDTO = new ResultDTO("tundra","frozen","Hoth", apparitionList);
        resultList.add(resultDTO);
        swapiDataMock.setResults(resultList);

        Mockito.when(planetRepository.save(planetDataMock)).thenReturn(planetDataMock);
        Mockito.when(swapiService.getApparitionQuantity(planetDataMock.getName())).thenReturn(swapiDataMock);
        planetService.create(planetDataMock);
        assertEquals(planetDataMock.getId(), 1);
        assertEquals(planetDataMock.getName(), "Hoth");
    }

    @Test
    public void createWithoutApparitions(){
        Planet planetDataMock = new Planet( 1L,"Hoth", "frozen", "tundra, ice caves, mountain ranges", 1);
        SwapiDTO swapiDataMock = new SwapiDTO();
        List<ResultDTO> resultList = new ArrayList<>();
        swapiDataMock.setResults(resultList);

        Mockito.when(planetRepository.save(planetDataMock)).thenReturn(planetDataMock);
        Mockito.when(swapiService.getApparitionQuantity(planetDataMock.getName())).thenReturn(swapiDataMock);
        planetService.create(planetDataMock);
        assertEquals(planetDataMock.getId(), 1);
        assertEquals(planetDataMock.getName(), "Hoth");
    }

    @Test
    public void findAll(){
        List<Planet> planetList = new ArrayList<>();
        Planet planetDataMock = new Planet( 1L,"Hoth", "frozen", "tundra, ice caves, mountain ranges", 1);
        planetList.add(planetDataMock);
        Mockito.when(planetRepository.findAll()).thenReturn(planetList);
        planetService.findAll();
        assertEquals(planetList.get(0).getId(), 1);
        assertEquals(planetList.get(0).getName(), "Hoth");
    }

    @Test
    public void findByid() {
        Planet planetDataMock = new Planet( 1L,"Hoth", "frozen", "tundra, ice caves, mountain ranges", 1);
        Mockito.when(planetRepository.findById(1L)).thenReturn(Optional.of(planetDataMock));
        planetService.findById(1L);
        assertEquals(planetDataMock.getId(), 1);
        assertEquals(planetDataMock.getName(), "Hoth");
    }

    @Test
    public void findByName() {
        Planet planetDataMock = new Planet( 1L,"Hoth", "frozen", "tundra, ice caves, mountain ranges", 1);
        Mockito.when(planetRepository.findByName("Hoth")).thenReturn(Optional.of(planetDataMock));
        planetService.findByName("Hoth");
        assertEquals(planetDataMock.getId(), 1);
        assertEquals(planetDataMock.getName(), "Hoth");
    }
    @Test
    public void delete() {
        Planet planetDataMock = new Planet( 1L,"Hoth", "frozen", "tundra, ice caves, mountain ranges", 1);
        doNothing().when(planetRepository).deleteById(1L);
        planetService.delete(1L);
        assertEquals(planetDataMock.getId(), 1);
        assertEquals(planetDataMock.getName(), "Hoth");
    }




}
