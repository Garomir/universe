package com.garomir.universe.controller;

import com.garomir.universe.entities.Lord;
import com.garomir.universe.entities.Planet;
import com.garomir.universe.services.LordService;
import com.garomir.universe.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        Lord emptyLord = new Lord();
        model.addAttribute("lords", lords);
        model.addAttribute("lord", emptyLord);
        return "lords";
    }

    @GetMapping("/planets")
    public String viewPlanets(Model model){
        List<Planet> planets = new ArrayList<>();
        planets = planetService.getAllPlanets();
        Planet planet = new Planet();
        model.addAttribute("planets", planets);
        model.addAttribute("planet", planet);
        return "planets";
    }

    @PostMapping("/addlord")
    public String addLord(@ModelAttribute(value = "lord") Lord lord){
        lordService.addLord(lord);
        return "redirect:/lords";
    }

    @GetMapping("/getfreelords")
    public String getFreeLords(Model model) {
        List<Lord> lords = new ArrayList<>();
        lords = lordService.getFreeLords();
        Lord emptyLord = new Lord();
        model.addAttribute("lords", lords);
        model.addAttribute("lord", emptyLord);
        return "lords";
    }

    @GetMapping("/gettop10lords")
    public String getTop10Lords(Model model) {
        List<Lord> lords = new ArrayList<>();
        lords = lordService.getTop10Lords();
        Lord emptyLord = new Lord();
        model.addAttribute("lords", lords);
        model.addAttribute("lord", emptyLord);
        return "lords";
    }

    @PostMapping("/addplanet")
    public String addPlanet(@ModelAttribute(value = "planet") Planet planet){
        planetService.addPlanet(planet);
        return "redirect:/planets";
    }
}
