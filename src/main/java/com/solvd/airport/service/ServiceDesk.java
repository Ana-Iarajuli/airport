package com.solvd.airport.service;

import com.solvd.airport.passenger.Ticket;
import com.solvd.airport.exceptions.InvalidTicketException;

public final class ServiceDesk {

    public static final String LOCATION = "Tatooine";

    private final String deskId;

    static {
        System.out.println("Service desk at your main.java.com.solvd.airport.service at: " + LOCATION);
    }

    public ServiceDesk(String deskId) {
        this.deskId = deskId;
    }

    public final String getDeskId() {
        return deskId;
    }

    public static void announce(String message) {
        System.out.println("Announcement of Republic: " + message);
    }

    public void assistCheckIn(CheckInService checkInService, Ticket ticket) {
        try {
            boolean ok = checkInService.checkIn(ticket);
            System.out.println("Desk ID: " + deskId + " check in result: " + ok);
        } catch (InvalidTicketException e) {
            System.out.println("Desk ID: " + deskId + " check in failed: " + e.getMessage());
        }
    }
}


