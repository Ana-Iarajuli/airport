package main.java.com.solvd.airport.lambda;

import main.java.com.solvd.airport.flight.Seat;

import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
public interface SeatSelector {
    Seat allocate(List<Seat> seats, Predicate<Seat> seatFilter);
}