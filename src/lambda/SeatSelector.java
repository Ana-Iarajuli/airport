package lambda;

import flight.Seat;

import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
public interface SeatSelector {
    Seat allocate(List<Seat> seats, Predicate<Seat> seatFilter);
}