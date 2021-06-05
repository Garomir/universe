package com.garomir.universe.controller;

import com.garomir.universe.entities.Lord;
import com.garomir.universe.entities.Planet;
import com.garomir.universe.services.LordService;
import com.garomir.universe.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class MyController {

    private LordService lordService;
    private PlanetService planetService;

    @Autowired
    public MyController(LordService lordService, PlanetService planetService) {
        this.lordService = lordService;
        this.planetService = planetService;
    }

    @GetMapping("/index")
    public String viewIndex(){
        return "index";
    }

    @GetMapping("/lords")
    public String viewLords(Model model){
        List<Lord> lords = new ArrayList<>();
        lords = lordService.getAllLords();
        model.addAttribute("lords", lords);
        return "lords";
    }

    @GetMapping("/planets")
    public String viewPlanets(Model model){
        List<Planet> planets = new ArrayList<>();
        planets = planetService.getAllPlanets();
        model.addAttribute("planets", planets);
        return "planets";
    }


}
