package com.garomir.universe.services.impl;

import com.garomir.universe.entities.Lord;
import com.garomir.universe.entities.Planet;
import com.garomir.universe.repos.PlanetRepo;
import com.garomir.universe.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class PlanetServiceImpl implements PlanetService {

    private PlanetRepo planetRepo;

    @Autowired
    public PlanetServiceImpl(PlanetRepo planetRepo) {
        this.planetRepo = planetRepo;
    }

    @Override
    public Planet addPlanet(Planet planet) {
        return planetRepo.save(planet);
    }

    @Override
    public void deletePlanet(int id) {
        planetRepo.deleteById(id);
    }

    @Override
    public void setLordForPlanet(int id, Lord lord) {
        Optional<Planet> opt = planetRepo.findById(id);
        if (!opt.isPresent()){
            throw new EntityNotFoundException("Entity not found");
        }
        Planet planet = opt.get();
        planet.setLord(lord);
    }
}
