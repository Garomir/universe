package com.garomir.universe.services.impl;

import com.garomir.universe.entities.Lord;
import com.garomir.universe.entities.Planet;
import com.garomir.universe.prototype.LordPrototype;
import com.garomir.universe.repos.LordRepo;
import com.garomir.universe.services.LordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.garomir.universe.prototype.LordPrototype.*;
import static com.garomir.universe.prototype.PlanetPrototype.takePlanet;
import static com.garomir.universe.prototype.PlanetPrototype.takePlanets;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LordServiceImplTest {

    private LordRepo lordRepo;
    private LordService lordService;

    @BeforeEach
    void setUp() {
        lordRepo = mock(LordRepo.class);
        lordService = new LordServiceImpl(lordRepo);
    }

    @Test
    void addLord() {
        when(lordRepo.save(any())).thenReturn(takeLord());
        Lord createdLord = lordService.addLord(takeLord());
        assertThat(createdLord).isNotNull();
        assertThat(createdLord.getName()).isEqualTo(takeLord().getName());
    }

    @Test
    void getFreeLords() {
    }

    @Test
    void getTop10Lords() {
    }

    @Test
    void getAllLords() {
        when(lordRepo.findAll()).thenReturn(takeLords());
        List<Lord> foundLords = lordService.getAllLords();
        assertThat(foundLords.size()).isEqualTo(5);
    }

    @Test
    void isLordExists() {
        when(lordRepo.getById(eq(1))).thenReturn(takeLord());
        boolean isLordExists = lordService.isLordExists(takeLord().getId());
        assertFalse(isLordExists);
    }
}