package lambda;

import flight.Flight;
import passenger.Passenger;

@FunctionalInterface
public interface FlightAlert {
    void notify(Passenger passenger, Flight flight, String message);
}
