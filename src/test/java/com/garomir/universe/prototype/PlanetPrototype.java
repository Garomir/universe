package com.garomir.universe.prototype;

import com.garomir.universe.entities.Planet;

public class PlanetPrototype {

    public static Planet takePlanet(){
        Planet p = new Planet();
        p.setId(1);
        p.setName("testName");
        return p;
    }
}
