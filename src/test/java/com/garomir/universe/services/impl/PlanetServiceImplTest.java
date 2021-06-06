package com.garomir.universe.services.impl;

import com.garomir.universe.entities.Planet;
import com.garomir.universe.prototype.PlanetPrototype;
import com.garomir.universe.repos.LordRepo;
import com.garomir.universe.repos.PlanetRepo;
import com.garomir.universe.services.PlanetService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static com.garomir.universe.prototype.PlanetPrototype.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlanetServiceImplTest {

    private PlanetRepo planetRepo;
    private LordRepo lordRepo;
    private PlanetService planetService;

    @BeforeEach
    void setUp(){
        planetRepo = mock(PlanetRepo.class);
        lordRepo = mock(LordRepo.class);
        planetService = new PlanetServiceImpl(planetRepo, lordRepo);
    }

    @Test
    void addPlanet() {
        when(planetRepo.save(any())).thenReturn(takePlanet());
        Planet createdPlanet = planetService.addPlanet(takePlanet());
        assertThat(createdPlanet).isNotNull();
        assertThat(createdPlanet.getName()).isEqualTo(takePlanet().getName());
    }

    @Test
    void findPlanetById() {
        when(planetRepo.getById(eq(1))).thenReturn(takePlanet());
        Planet foundPlanet = planetService.findPlanetById(1);
        assertThat(foundPlanet).isNotNull();
        assertThat(foundPlanet.getName()).isEqualTo("testName");
    }

    @Test
    void getAllPlanets() {
        when(planetRepo.findAll()).thenReturn(takePlanets());
        List<Planet> foundPlanets = planetService.getAllPlanets();
        assertThat(foundPlanets.size()).isEqualTo(5);
    }

    @Test
    void deletePlanet() {
    }
}