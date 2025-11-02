package com.solvd.airport.lambda;

import com.solvd.airport.enums.SeatClass;
import com.solvd.airport.passenger.Passenger;

import java.math.BigDecimal;


@FunctionalInterface
public interface FareCalculator {
    BigDecimal apply(BigDecimal baseFare, Passenger passenger, SeatClass seatClass);
}
