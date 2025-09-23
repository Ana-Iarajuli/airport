import core.*;
import flight.*;
import passenger.*;
import service.*;
import exceptions.InvalidTicketException;
import exceptions.SeatOccupiedRuntimeException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class MainClass {

    public static void main(String[] args) {

        Passenger memberPassenger = new Passenger(1, "Obi-wan", "Kenobi",
                "thebest@jedi.com", "male", LocalDate.of(1965, 6, 26), true);

        Passenger regularPassenger = new Passenger(2, "Luke", "Skywalker",
                "luke@rebellion.com", "male",
                LocalDate.of(1977, 5, 25), false);

        Employee pilot = new Employee("Han", "Solo", "han@smugglers.com", "male",
                LocalDate.of(1942, 7, 13), "Pilot Captain");

        List<Person> people = Arrays.asList(memberPassenger, regularPassenger, pilot);
        for (Person person : people) {
            System.out.println("- " + person.toString());
        }

        Airplane airplane1 = new Airplane("Galactic Motors", 223);
        Airplane airplane2 = new Airplane("Incom Corporation", 22);

        Bus bus = new Bus("Galactic Motors", 30);

        List<Transport> transports = Arrays.asList(airplane1, airplane2, bus);
//        for (Transport transport : transports) {
//            System.out.println(transport.toString() + ", ");
//        }

        System.out.println("-------------");
        Airport airport = new Airport("Tatooine airport");
//        System.out.println(airport.getAirportName());

        airport.setTransports(transports);
        for (Transport t : airport.getTransports()) {
            System.out.println("- Transport" + t);
        }

        Terminal t1 = new Terminal("T1", 111, 13);
        Terminal t2 = new Terminal("T2", 121, 11);
        airport.setTerminals(Arrays.asList(t1, t2));

//        for (Terminal t : airport.getTerminals()) {
//            System.out.println("terminal" + t);
//        }

        Map<Integer, Terminal> terminalMap = new HashMap<>();
        for (Terminal t : airport.getTerminals()) {
            terminalMap.put(t.getTerminalNumber(), t);
        }

        System.out.println("-------------");
        for (Map.Entry<Integer, Terminal> entry : terminalMap.entrySet()) {
            System.out.println("- Terminal Number: " + entry.getKey() + " - " + entry.getValue());
        }

//        Gate gate1 = new Gate(19);
//        Gate gate2 = new Gate(13);
//        Gate gate3 = new Gate(3);

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
