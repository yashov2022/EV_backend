package com.ev.ev_project.controller;

import com.ev.ev_project.DTO.BookingRequest;
import com.ev.ev_project.DTO.BookingResponse;
import com.ev.ev_project.entity.Booking;
import com.ev.ev_project.service.BookingService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/book")
public class BookingController {

    @Autowired
    private BookingService service;

    @PostMapping
    public BookingResponse bookslot(
            @RequestBody BookingRequest request)
    {
        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        String username =
                authentication.getName();

        Booking booking = service.bookSlot(
                request.getSlotId(),
                username,
                request.getVehicleNumber()
        );

        BookingResponse response =
                new BookingResponse();

        response.setId(
                booking.getId()
        );

        response.setSlotId(
                booking.getSlot().getId()
        );

        response.setUserName(
                booking.getUserName()
        );

        response.setVehicleNumber(
                booking.getVehicleNumber()
        );

        response.setBookingTime(
                booking.getBookingTime()
        );

        return response;
    }

    @GetMapping("/history")
    public List<Booking> getHistory()
    {
        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        String username =
                authentication.getName();

        return service.getAllBookings(
                username
        );
    }
}