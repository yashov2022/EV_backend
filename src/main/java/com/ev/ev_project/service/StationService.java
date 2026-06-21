package com.ev.ev_project.service;

import com.ev.ev_project.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ev.ev_project.repository.StationRepository;
import java.util.*;
@Service
public class StationService {

    @Autowired
    private StationRepository repo;

    public List<Station> getAllstations()
    {
        return repo.findAll();
    }

}
