package com.solvd.airport.lambda;

import com.solvd.airport.flight.Flight;
import com.solvd.airport.passenger.Passenger;

@FunctionalInterface
public interface FlightAlert {
    void notify(Passenger passenger, Flight flight, String message);
}
