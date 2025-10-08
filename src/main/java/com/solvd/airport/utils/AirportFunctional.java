package main.java.com.solvd.airport.utils;

import main.java.com.solvd.airport.enums.*;
import main.java.com.solvd.airport.flight.Flight;
import main.java.com.solvd.airport.flight.Seat;
import main.java.com.solvd.airport.passenger.Passenger;
import main.java.com.solvd.airport.lambda.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.*;

public class AirportFunctional {

    public static class PriceBreakdown {
        private final BigDecimal base;
        private final BigDecimal finalPrice;

        public PriceBreakdown(BigDecimal base, BigDecimal finalPrice, String note) {
            this.base = base;
            this.finalPrice = finalPrice;
        }

        public BigDecimal getBase() { return base; }
        public BigDecimal getFinalPrice() { return finalPrice; }
        @Override public String toString() { return "Base price: " + base + ", Final price: " + finalPrice; }
    }

    public static PriceBreakdown processBooking(
            Passenger passenger,
            Flight flight,
            List<Seat> availableSeats,
            BigDecimal baseFare,

            Predicate<Seat> seatFilter,
            Function<Passenger, BigDecimal> discount,
            Consumer<PriceBreakdown> auditLogger,
            Supplier<SeatClass> seatClassSupplier,

            FareCalculator fareCalculator,
            FlightAlert flightAlert,
            SeatSelector seatSelector
    ) {
        Objects.requireNonNull(passenger);
        Objects.requireNonNull(flight);
        List<Seat> seatsCopy = new ArrayList<>(availableSeats);

        Seat chosen = seatSelector.allocate(seatsCopy, seatFilter);
        if (chosen == null) {
            flightAlert.notify(passenger, flight, "No seats available for you");
            return new PriceBreakdown(baseFare, baseFare, "No seat chosen");
        }

        SeatClass seatClass = seatClassSupplier.get();
        BigDecimal membershipDiscount = discount.apply(passenger);
        BigDecimal seatPrice = fareCalculator.apply(baseFare, passenger, seatClass);

        BigDecimal total = seatPrice.subtract(membershipDiscount);

        String note = "Chosen seat: " + chosen.getSeatNumber() + " class: " + seatClass +
                " security level: " + SecurityLevel.MEDIUM.policy();

        PriceBreakdown breakdown = new PriceBreakdown(baseFare, total, note);
        auditLogger.accept(breakdown);
        flightAlert.notify(passenger, flight, "Your total price is: " + total);
        return breakdown;
    }
}

