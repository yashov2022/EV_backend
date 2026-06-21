package com.ev.ev_project.controller;

import com.ev.ev_project.entity.Slot;
import com.ev.ev_project.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/slots")
public class SlotController {
    @Autowired
    private SlotService service;

    @GetMapping("/{stationId}")
    public List<Slot> getSlots(
            @PathVariable int stationId) {

        return service.getSlots(stationId);
    }
}
