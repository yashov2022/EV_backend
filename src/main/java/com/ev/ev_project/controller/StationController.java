package com.ev.ev_project.controller;

import com.ev.ev_project.entity.Station;
import com.ev.ev_project.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/stations")
public class StationController {
    @Autowired
    private StationService service;
    @GetMapping
    public List<Station> getStations() {
        return service.getAllstations();
    }
}
