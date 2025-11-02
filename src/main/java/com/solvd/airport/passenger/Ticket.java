package com.solvd.airport.passenger;

import com.solvd.airport.flight.Flight;
import com.solvd.airport.flight.Seat;

import java.math.BigDecimal;

public class Ticket {

    private String tktNumber;
    private Passenger passenger;
    private Flight flight;
    private Seat seat;
    private BigDecimal tktPrice;

    public Ticket(String tktNumber, Passenger passenger, Flight flight,
                  Seat seat, BigDecimal tktPrice) {
        this.tktNumber = tktNumber;
        this.passenger = passenger;
        this.flight = flight;
        this.seat = seat;
        this.tktPrice = tktPrice;
    }

    public String getTktNumber() {
        return tktNumber;
    }

    public void setTktNumber(String tktNumber) {
        this.tktNumber = tktNumber;
    }
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public BigDecimal getTktPrice() {
        return tktPrice;
    }

    public void setTktPrice(BigDecimal tktPrice) {
        this.tktPrice = tktPrice;
    }
}
