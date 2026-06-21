package com.ev.ev_project.service;

import com.ev.ev_project.entity.Slot;
import com.ev.ev_project.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SlotService {
    @Autowired
    private SlotRepository repo;
    public List<Slot> getSlots(int stationId) {
        return repo.findByStationId(stationId);
    }
}
