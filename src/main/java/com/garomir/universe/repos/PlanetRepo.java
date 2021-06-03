package com.garomir.universe.repos;

import com.garomir.universe.entities.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepo extends JpaRepository<Planet, Integer> {
}
