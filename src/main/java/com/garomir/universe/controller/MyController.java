package com.garomir.universe.controller;

import com.garomir.universe.services.LordService;
import com.garomir.universe.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/universe")
public class MyController {

    private LordService lordService;
    private PlanetService planetService;

    @Autowired
    public MyController(LordService lordService, PlanetService planetService) {
        this.lordService = lordService;
        this.planetService = planetService;
    }

    
}
