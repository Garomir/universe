package com.garomir.universe.prototype;

import com.garomir.universe.entities.Planet;

import java.util.ArrayList;
import java.util.List;

public class PlanetPrototype {

    public static Planet takePlanet(){
        Planet p = new Planet();
        p.setId(1);
        p.setName("testName");
        return p;
    }

    public static List<Planet> takePlanets(){
        List<Planet> planets = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Planet p = new Planet();
            p.setId(i);
            p.setName("name" + i);
            planets.add(p);
        }
        return planets;
    }
}
