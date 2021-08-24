package com.starwars.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.api.dto.PlanetDTO;
import com.starwars.api.model.Planet;
import com.starwars.api.service.PlanetService;
import com.starwars.api.service.SwapiService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PlanetControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlanetService planetService;
    @MockBean
    private SwapiService swapiService;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void findAll() throws Exception {
        List<Planet> planetList = new ArrayList<>();
        Planet planetDataMock = new Planet( 1L,"Hoth", "frozen", "tundra, ice caves, mountain ranges", 1);
        planetList.add(planetDataMock);

        when(planetService.findAll()).thenReturn(planetList);
        mockMvc.perform(MockMvcRequestBuilders.get("/planets")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void create() throws Exception {
        Planet planetDataMock = new Planet( 1L,"Hoth", "frozen", "tundra", 0);
        String body = objectMapper.writeValueAsString(planetDataMock);

        when(planetService.create(planetDataMock)).thenReturn(planetDataMock);
        mockMvc.perform(MockMvcRequestBuilders.post("/planets")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(body))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void findById() throws Exception {
        Planet planetDataMock = new Planet( 1L,"Hoth", "frozen", "tundra, ice caves, mountain ranges", 1);

        when(planetService.findById(1L)).thenReturn(planetDataMock);
        mockMvc.perform(MockMvcRequestBuilders.get("/planets/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void delete() throws Exception {

        doNothing().when(planetService).delete(1L);
        mockMvc.perform(MockMvcRequestBuilders.delete("/planets/1")).andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void findByName() throws Exception {
        Planet planetDataMock = new Planet( 1L,"Hoth", "frozen", "tundra, ice caves, mountain ranges", 1);

        when(planetService.findByName("Hoth")).thenReturn(planetDataMock);
        mockMvc.perform(MockMvcRequestBuilders.get("/planets/name").param("name", "Hoth")).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void findAllPlanetsBySwapi() throws Exception {
        List<PlanetDTO> planetList = new ArrayList<>();
        PlanetDTO planetDataMock = new PlanetDTO( "Hoth", "frozen", "tundra, ice caves, mountain ranges", 1);
        planetList.add(planetDataMock);

        when(swapiService.getAllPlanets()).thenReturn(planetList);
        mockMvc.perform(MockMvcRequestBuilders.get("/planets/all")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
