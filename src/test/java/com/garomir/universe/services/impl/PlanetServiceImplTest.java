package com.garomir.universe.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.garomir.universe.entities.Planet;
import com.garomir.universe.repos.PlanetRepo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
class PlanetServiceImplTest {

    @Autowired
    private PlanetServiceImpl planetService;

    @MockBean
    private PlanetRepo planetRepo;

    @Test
    void testAddPlanet() {
        Planet planet = new Planet();
        planet.setId(1);
        planet.setName("test");

        Mockito.when(planetRepo.save(planet)).thenReturn(planet);

        assertEquals(planet, planetService.addPlanet(planet));
    }

    @Test
    void deletePlanet() {
    }

    @Test
    void setLordForPlanet() {

    }
}