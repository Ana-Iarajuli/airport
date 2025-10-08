package main.java.com.solvd.airport.service;

import main.java.com.solvd.airport.flight.Flight;

public interface FlightManagementService {

    void delayFlight(Flight flight, int minutes);
}


