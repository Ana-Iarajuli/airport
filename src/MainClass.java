import core.*;
import flight.*;
import passenger.*;
import service.*;
import exceptions.InvalidTicketException;
import exceptions.SeatOccupiedRuntimeException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainClass {

    public static void main(String[] args) {

        Passenger memberPassenger = new Passenger(1, "Obi-wan", "Kenobi",
                "thebest@jedi.com", "male", LocalDate.of(1965, 6, 26), true);

        Passenger regularPassenger = new Passenger(2, "Luke", "Skywalker",
                "luke@rebellion.com", "male",
                LocalDate.of(1977, 5, 25), false);

        Employee pilot = new Employee("Han", "Solo", "han@smugglers.com", "male",
                LocalDate.of(1942, 7, 13), "Pilot Captain");

        Person[] people = {memberPassenger, regularPassenger, pilot};
        for (Person person : people) {
            System.out.println("  • " + person.toString());
        }

        Airplane airplane1 = new Airplane("Galactic Motors", 223);
        Airplane airplane2 = new Airplane("Incom Corporation", 22);

        Bus bus = new Bus("Galactic Motors", 30);

        Transport[] transports = {airplane1, airplane2, bus};
        for (Transport transport : transports) {
            System.out.println(transport.toString() + ", ");
        }

        Airport airport = new Airport("Tatooine airport");
        System.out.println(airport.getAirportName());
        
        airport.setTransports(transports);
        System.out.println("Airport transports:");
        for (Transport t : airport.getTransports()) {
            System.out.println("  • " + t);
        }

        airport.setTransports(transports);
        System.out.println("Airport transports:");
        for (Transport t : airport.getTransports()) {
            System.out.println("  • " + t);
        }

        Terminal t1 = new Terminal("T1", 111, 13);
        airport.setTerminals(new Terminal[]{t1});

        Gate gate1 = new Gate(19);
        Gate gate2 = new Gate(13);
        Gate gate3 = new Gate(3);


        Seat seat1 = new Seat("23B", true);
        seat1.setPrice(new BigDecimal("123.4"));
        Seat seat2 = new Seat("3C", false);
        seat2.setPrice(new BigDecimal("119.4"));
        Seat seat3 = new Seat("28B", true);
        seat3.setPrice(new BigDecimal("123.4"));
        Seat seat4 = new Seat("13A", false);
        seat4.setPrice(new BigDecimal("119.4"));

        Flight flight = new Flight(1, "Death Star",
                LocalDateTime.of(2024, 12, 16, 14, 0),
                LocalDateTime.of(2024, 12, 16, 20, 30)
        );

        Booking bookingService = new Booking();
        
        airport.setCheckInService(bookingService);
        airport.setBoardingService(bookingService);
        airport.setFlightManagementService(bookingService);

        Ticket ticket1 = bookingService.BookTkt(memberPassenger, flight, seat2);
        if (ticket1 != null) {
            System.out.println("Created ticket: " + ticket1.getTktNumber() +
                    ", seat: " + ticket1.getSeat().getSeatNumber() +
                    ", price: " + ticket1.getTktPrice());
        }

        Ticket ticket2 = null;
        try {
            ticket2 = bookingService.BookTkt(regularPassenger, flight, seat2);
        } catch (SeatOccupiedRuntimeException e) {
            System.out.println("Error booking seat: " + e.getMessage());
        } finally {
            System.out.println("Finished booking for seat " + seat2.getSeatNumber());
        }
//        System.out.println("booking for occupied seat: " + ticket2);

        System.out.println("Total bookings: " + Booking.getBookings());
        System.out.println("-----------------------");

        try (ServiceSession session = new ServiceSession()) {
            airport.getCheckInService().checkIn(ticket1);
        } catch (InvalidTicketException e) {
            System.out.println("Check in failed: " + e.getMessage());
        }
        airport.getBoardingService().boardPassenger(ticket1);
        airport.getFlightManagementService().delayFlight(flight, 15);

        ServiceDesk.announce("Boarding begins at Gate 13");
        ServiceDesk desk = new ServiceDesk("Service Desk-01.");
        desk.assistCheckIn(bookingService, ticket1);

    }
}
