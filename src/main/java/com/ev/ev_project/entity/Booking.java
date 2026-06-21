package com.ev.ev_project.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

    @Entity
    @Table(name = "bookings")
    public class Booking {

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Slot getSlot() {
            return slot;
        }

        public void setSlot(Slot slot) {
            this.slot = slot;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getVehicleNumber() {
            return vehicleNumber;
        }

        public void setVehicleNumber(String vehicleNumber) {
            this.vehicleNumber = vehicleNumber;
        }

        public LocalDateTime getBookingTime() {
            return bookingTime;
        }

        public void setBookingTime(LocalDateTime bookingTime) {
            this.bookingTime = bookingTime;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne
        @JoinColumn(name = "slot_id")
        private Slot slot;

        @Column(name = "user_name")
        private String userName;

        @Column(name = "vehicle_number")
        private String vehicleNumber;

        @Column(name = "booking_time")
        private LocalDateTime bookingTime;

    }

