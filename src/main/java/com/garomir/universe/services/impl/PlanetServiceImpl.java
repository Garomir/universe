package com.garomir.universe.services.impl;

import com.garomir.universe.entities.Lord;
import com.garomir.universe.entities.Planet;
import com.garomir.universe.repos.LordRepo;
import com.garomir.universe.repos.PlanetRepo;
import com.garomir.universe.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PlanetServiceImpl implements PlanetService {

    private PlanetRepo planetRepo;
    private LordRepo lordRepo;

    @Autowired
    public PlanetServiceImpl(PlanetRepo planetRepo, LordRepo lordRepo) {
        this.planetRepo = planetRepo;
        this.lordRepo = lordRepo;
    }

    @Override
    public Planet addPlanet(Planet planet) {
        return planetRepo.save(planet);
    }

    @Override
    public List<Planet> getAllPlanets() {
        return planetRepo.findAll();
    }

    @Override
    public void deletePlanet(int id) {
        planetRepo.deleteById(id);
    }

    @Override
    public void setLordForPlanet(int id, int lordId) {
        Optional<Planet> opt = planetRepo.findById(id);
        if (!opt.isPresent()){
            throw new EntityNotFoundException("Entity not found");
        }
        Planet planet = opt.get();
        Lord lord = lordRepo.getById(lordId);
        planet.setLord(lord);
        planetRepo.save(planet);
    }
}
