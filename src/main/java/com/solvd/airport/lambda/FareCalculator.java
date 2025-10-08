package main.java.com.solvd.airport.lambda;

import main.java.com.solvd.airport.enums.SeatClass;
import main.java.com.solvd.airport.passenger.Passenger;

import java.math.BigDecimal;


@FunctionalInterface
public interface FareCalculator {
    BigDecimal apply(BigDecimal baseFare, Passenger passenger, SeatClass seatClass);
}
