package com.ev.ev_project.repository;

import com.ev.ev_project.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByUserName(
            String userName
    );
}
