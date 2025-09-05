package service;

import flight.Flight;
import flight.Seat;
import passenger.Passenger;
import passenger.Ticket;

import java.math.BigDecimal;

public class Booking {

    private static int bookings = 0;

    private boolean isOnline;

    static {
        System.out.println("service.Booking Service requested");
    }

    public static int getBookings() {
        return bookings;
    }
    public Booking() {
        this.isOnline = true;
    }

    public Ticket BookTkt(Passenger passenger, Flight flight, Seat seat) {
        if (seat.isOccupied()) {
            System.out.println("Seat is occupied.");
            return null;
        }
        Ticket tkt = new Ticket(passenger, flight, seat, seat.getPrice());
        seat.setOccupied(true);
        bookings++;

        confirmation(passenger, tkt);

        return tkt;
    }

    private void confirmation(Passenger passenger, Ticket tkt) {
        System.out.println("Booking successful!");
        System.out.println("Ticket details sent on " + passenger.getPassengerEmail() +
                " with tkt number: " + tkt.getTktNumber());
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}




