package service;

import core.Person;
import flight.Flight;
import flight.Seat;
import passenger.Passenger;
import passenger.Ticket;
import exceptions.InvalidTicketException;
import exceptions.SeatOccupiedRuntimeException;
import exceptions.UnauthorizedOperationException;
import exceptions.InvalidFlightOperationException;

import java.math.BigDecimal;

public class Booking implements CheckInService, BoardingService, FlightManagementService {

    private static int bookings = 0;
    private static final BigDecimal MEMBER_DISCOUNT = new BigDecimal("0.25");
    private boolean isOnline;

    private Person[] customers;

    static {
        System.out.println("Booking Service is requested");
    }

    public static int getBookings() {
        return bookings;
    }
    public Booking() {
        this.isOnline = true;
        this.customers = new Person[13];
    }



    public Ticket BookTkt(Passenger passenger, Flight flight, Seat seat) {
        if (seat.isOccupied()) {
            throw new SeatOccupiedRuntimeException("Seat " + seat.getSeatNumber() + " is already occupied");
        }
        BigDecimal finalPrice = calculateDiscount(passenger, seat);
        String tktnumber = "TKT-" + (bookings + 1);

        Ticket tkt = new Ticket(tktnumber, passenger, flight, seat, finalPrice);
        seat.setOccupied(true);
        bookings++;

        confirmation(passenger, tkt);

        return tkt;
    }

    @Override
    public boolean checkIn(Ticket ticket) throws InvalidTicketException {
        if (ticket == null) {
            throw new InvalidTicketException("Ticket can't be null");
        }
        System.out.println("Checked in: " + ticket.getTktNumber());
        return true;
    }

    @Override
    public void boardPassenger(Ticket ticket) {
        System.out.println("Boarding passenger with ticket: " + ticket.getTktNumber());
    }

    @Override
    public void delayFlight(Flight flight, int minutes) {
        if (minutes < 0) {
            throw new InvalidFlightOperationException("Flightt delay minutes can't be negative");
        }
        System.out.println("Flight " + flight.getFlightId() + " is delayed by " + minutes + " minutes");
        flight.setDeparture(flight.getDeparture().plusMinutes(minutes));
        flight.setArrival(flight.getArrival().plusMinutes(minutes));
    }

    protected BigDecimal calculateDiscount(Person person, Seat seat) {
        BigDecimal price = seat.getPrice();
        if (person.hasDiscount()) {
            BigDecimal discount = price.multiply(MEMBER_DISCOUNT);
            BigDecimal finalPrice = price.subtract(discount);
            return finalPrice;
        }
        return price;
    }

    protected void addCustomer(Person person) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                customers[i] = person;
                break;
            }
        }
    }

    protected void confirmation(Passenger passenger, Ticket tkt) {
        System.out.println("Booking successful!");
        System.out.println("Ticket details sent on " + passenger.getEmail() +
                " with tkt number: " + tkt.getTktNumber());
    }

    public void displayCustomers() {
        System.out.println("Customers: ");
        for (Person person : customers) {
            if (person != null) {
                System.out.println("Customer: " + person.toString());
                System.out.println("Role is: " + person.personRole());
                System.out.println("Gets discount: " + person.hasDiscount());
            }
        }
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}




