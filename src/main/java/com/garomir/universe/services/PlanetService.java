package com.garomir.universe.services;

import com.garomir.universe.entities.Lord;
import com.garomir.universe.entities.Planet;

import java.util.List;

public interface PlanetService {
    Planet addPlanet(Planet planet);
    List<Planet> getAllPlanets();
    void deletePlanet(int id);
    void setLordForPlanet(int id, int lordId);
}
