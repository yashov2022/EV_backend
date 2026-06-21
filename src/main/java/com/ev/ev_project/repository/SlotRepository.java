package com.ev.ev_project.repository;

import com.ev.ev_project.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Integer>
{
    long countByIsAvailable(boolean isAvailable);
    List<Slot> findByStationId(int stationId);
}

