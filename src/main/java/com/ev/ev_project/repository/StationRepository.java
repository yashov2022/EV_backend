package com.ev.ev_project.repository;

import com.ev.ev_project.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository
    extends JpaRepository<Station, Integer>{
}
