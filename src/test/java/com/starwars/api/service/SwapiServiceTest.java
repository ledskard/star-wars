package com.starwars.api.service;

import com.starwars.api.dto.ResultDTO;
import com.starwars.api.dto.SwapiDTO;
import com.starwars.api.repository.PlanetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class SwapiServiceTest {

    @TestConfiguration
    static class SwapiServiceTestConfiguration {
        @Bean
        public SwapiService swapiService(){
            return new SwapiService();
        }
    }

    @Autowired
    private SwapiService swapiService;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void getApparitionQuantity() {
        List<String> apparitionList = new ArrayList<>();
        SwapiDTO swapiDataMock = new SwapiDTO();
        List<ResultDTO> resultList = new ArrayList<>();
        apparitionList.add("https://swapi.dev/api/films/3/");
        apparitionList.add("https://swapi.dev/api/films/2/");
        ResultDTO resultDTO = new ResultDTO("tundra","frozen","Hoth", apparitionList);
        resultList.add(resultDTO);
        swapiDataMock.setResults(resultList);
        when(restTemplate.getForObject("https://swapi.dev/api/planets/", SwapiDTO.class)).thenReturn(swapiDataMock);
        swapiService.getApparitionQuantity("Hoth");

    }

    @Test
    public void getAllPlanets() {
        List<String> apparitionList = new ArrayList<>();
        SwapiDTO swapiDataMock = new SwapiDTO();
        List<ResultDTO> resultList = new ArrayList<>();
        apparitionList.add("https://swapi.dev/api/films/3/");
        apparitionList.add("https://swapi.dev/api/films/2/");
        ResultDTO resultDTO = new ResultDTO("tundra","frozen","Hoth", apparitionList);
        resultList.add(resultDTO);
        swapiDataMock.setResults(resultList);
        when(restTemplate.getForObject("https://swapi.dev/api/planets/", SwapiDTO.class)).thenReturn(swapiDataMock);
        swapiService.getAllPlanets();

    }

}
