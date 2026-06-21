package com.ev.ev_project.DTO;

public class DashboardResponse {
    public long getTotalStations() {
        return totalStations;
    }

    public void setTotalStations(long totalStations) {
        this.totalStations = totalStations;
    }

    public long getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(long totalSlots) {
        this.totalSlots = totalSlots;
    }

    public long getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(long availableSlots) {
        this.availableSlots = availableSlots;
    }

    public long getBookedSlots() {
        return bookedSlots;
    }

    public void setBookedSlots(long bookedSlots) {
        this.bookedSlots = bookedSlots;
    }

    public long getTotalBookings() {
        return totalBookings;
    }

    public void setTotalBookings(long totalBookings) {
        this.totalBookings = totalBookings;
    }

    private long totalStations;
    private long totalSlots;
    private long availableSlots;
    private long bookedSlots;
    private long totalBookings;

}
