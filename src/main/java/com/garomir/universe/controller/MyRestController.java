package com.garomir.universe.controller;

import com.garomir.universe.entities.Lord;
import com.garomir.universe.entities.Planet;
import com.garomir.universe.services.LordService;
import com.garomir.universe.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class MyRestController {

    private LordService lordService;
    private PlanetService planetService;

    @Autowired
    public MyRestController(LordService lordService, PlanetService planetService) {
        this.lordService = lordService;
        this.planetService = planetService;
    }

    @PostMapping("/lord")
    public ResponseEntity<Lord> addLord(@RequestBody Lord lord){
        Lord lord1 = lordService.addLord(lord);
        return ResponseEntity.status(201).body(lord1);
    }

    @GetMapping("/lord/free")
    public ResponseEntity<List<Lord>> getFreeLords(){
        List<Lord> lords = lordService.getFreeLords();
        return ResponseEntity.ok().body(lords);
    }

    @GetMapping("/lord/top10")
    public ResponseEntity<List<Lord>> getTop10Lords(){
        List<Lord> lords = lordService.getTop10Lords();
        return ResponseEntity.ok().body(lords);
    }

    @PostMapping("/planet")
    public ResponseEntity<Planet> addPlanet(@RequestBody Planet planet){
        Planet planet1 = planetService.addPlanet(planet);
        return ResponseEntity.status(201).body(planet1);
    }

    @DeleteMapping("/planet/{id}")
    public void deletePlanet(@PathVariable("id") int id){
        planetService.deletePlanet(id);
    }

    @PutMapping("/planet/{id}")
    public void updatePlanet(@PathVariable("id") int id, @RequestBody Lord lord){
        planetService.setLordForPlanet(id, lord);
    }
}
