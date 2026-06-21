package com.ev.ev_project.service;

import com.ev.ev_project.DTO.DashboardResponse;
import com.ev.ev_project.repository.BookingRepository;
import com.ev.ev_project.repository.SlotRepository;
import com.ev.ev_project.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    @Autowired
    private StationRepository stationRepo;

    @Autowired
    private SlotRepository slotRepo;

    @Autowired
    private BookingRepository bookingRepo;

    public DashboardResponse getDashboardData() {

        DashboardResponse response =
                new DashboardResponse();

        response.setTotalStations(
                stationRepo.count());

        response.setTotalSlots(
                slotRepo.count());

        response.setAvailableSlots(
                slotRepo.countByIsAvailable(true));

        response.setBookedSlots(
                slotRepo.countByIsAvailable(false));

        response.setTotalBookings(
                bookingRepo.count());

        return response;
    }
}
