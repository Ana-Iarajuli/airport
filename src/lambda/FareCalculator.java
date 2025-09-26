package lambda;

import enums.SeatClass;
import passenger.Passenger;

import java.math.BigDecimal;


@FunctionalInterface
public interface FareCalculator {
    BigDecimal apply(BigDecimal baseFare, Passenger passenger, SeatClass seatClass);
}
