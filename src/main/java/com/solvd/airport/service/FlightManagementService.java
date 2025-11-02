package com.solvd.airport.service;

import com.solvd.airport.flight.Flight;

public interface FlightManagementService {

    void delayFlight(Flight flight, int minutes);
}


