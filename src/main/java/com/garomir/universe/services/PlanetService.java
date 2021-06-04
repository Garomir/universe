package com.garomir.universe.services;

import com.garomir.universe.entities.Lord;
import com.garomir.universe.entities.Planet;

public interface PlanetService {
    Planet addPlanet(Planet planet);
    void deletePlanet(int id);
    void setLordForPlanet(int id, int lordId);
}
