package main.java.com.solvd.airport.lambda;

import main.java.com.solvd.airport.flight.Flight;
import main.java.com.solvd.airport.passenger.Passenger;

@FunctionalInterface
public interface FlightAlert {
    void notify(Passenger passenger, Flight flight, String message);
}
