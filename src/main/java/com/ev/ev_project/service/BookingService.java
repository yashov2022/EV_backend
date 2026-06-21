package com.ev.ev_project.service;

import com.ev.ev_project.entity.Booking;
import com.ev.ev_project.entity.Slot;
import com.ev.ev_project.repository.BookingRepository;
import com.ev.ev_project.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Service
@CrossOrigin(origins = "http://localhost:5173")
public class BookingService {
    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private SlotRepository slotRepo;
    @PostMapping
    public Booking bookSlot(
            int slotId,
            String userName,
            String vehicleNumber) {

        Slot slot = slotRepo.findById(slotId)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Slot not found"
                        )
                );

        if (!slot.isAvailable()) {

            throw new RuntimeException(
                    "Slot already booked"
            );
        }

        slot.setAvailable(false);
        slotRepo.save(slot);

        Booking booking = new Booking();

        booking.setSlot(slot);

        booking.setUserName(userName);

        booking.setVehicleNumber(vehicleNumber);

        booking.setBookingTime(LocalDateTime.now());

        return bookingRepo.save(booking);
    }
    public List<Booking> getAllBookings(String username) {
      return bookingRepo.findByUserName(
                username
        );
    }
}


