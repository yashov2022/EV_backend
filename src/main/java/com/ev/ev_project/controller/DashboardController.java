package com.ev.ev_project.controller;

import com.ev.ev_project.DTO.DashboardResponse;
import com.ev.ev_project.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "http://localhost:5173")
public class DashboardController {
    @Autowired
    private DashboardService service;

    @GetMapping
    public DashboardResponse getDashboard() {

        return service.getDashboardData();

    }
}
