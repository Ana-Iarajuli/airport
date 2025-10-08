package com.solvd.airport;

import com.solvd.airport.core.*;
import com.solvd.airport.enums.SeatClass;
import com.solvd.airport.flight.*;
import com.solvd.airport.passenger.*;
import com.solvd.airport.service.*;
import com.solvd.airport.exceptions.InvalidTicketException;
import com.solvd.airport.exceptions.SeatOccupiedRuntimeException;

import com.solvd.airport.utils.AirportFunctional;
import com.solvd.airport.enums.*;
import com.solvd.airport.lambda.FareCalculator;
import com.solvd.airport.lambda.FlightAlert;
import com.solvd.airport.lambda.SeatSelector;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MainClass {

    private static final Logger logger = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) {

        PassengerRecord pr1 = new PassengerRecord(1, "Obi-wan", "Kenobi",
                "thebest@jedi.com", "male", LocalDate.of(1965, 6, 26), true);
        PassengerRecord pr2 = new PassengerRecord(2, "Luke", "Skywalker",
                "luke@rebellion.com", "male",
                LocalDate.of(1977, 5, 25), false);

        Passenger memberPassenger = new Passenger(pr1.id(), pr1.firstName(), pr1.Lastname(),
                pr1.email(), pr1.gender(), pr1.birthDate(), pr1.premiumMember());

        Passenger regularPassenger = new Passenger(pr2.id(), pr2.firstName(), pr2.Lastname(),
                pr2.email(), pr2.gender(), pr2.birthDate(), pr2.premiumMember());

        Employee pilot = new Employee("Han", "Solo", "han@smugglers.com", "male",
                LocalDate.of(1942, 7, 13), "Pilot Captain");

        List<Person> people = Arrays.asList(memberPassenger, regularPassenger, pilot);
        for (Person person : people) {
            logger.info("- " + person.toString());
        }

        Airplane airplane1 = new Airplane("Galactic Motors", 223);
        Airplane airplane2 = new Airplane("Incom Corporation", 22);

        Bus bus = new Bus("Galactic Motors", 30);

        List<Transport> transports = Arrays.asList(airplane1, airplane2, bus);
//        for (Transport transport : transports) {
//            System.out.println(transport.toString() + ", ");
//        }

        logger.info("-------------");
        Airport airport = new Airport("Tatooine airport");
//        System.out.println(airport.getAirportName());

        airport.setTransports(transports);
        for (Transport t : airport.getTransports()) {
            logger.info("- Transport" + t);
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

        logger.info("-------------");
        for (Map.Entry<Integer, Terminal> entry : terminalMap.entrySet()) {
            logger.info("- Terminal Number: " + entry.getKey() + " - " + entry.getValue());
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
            logger.info("Created ticket: " + ticket1.getTktNumber() +
                    ", seat: " + ticket1.getSeat().getSeatNumber() +
                    ", price: " + ticket1.getTktPrice());
        }

        Ticket ticket2 = null;
        try {
            ticket2 = bookingService.BookTkt(regularPassenger, flight, seat2);
        } catch (SeatOccupiedRuntimeException e) {
            logger.error("Error booking seat: " + e.getMessage());
        } finally {
            logger.info("Finished booking for seat " + seat2.getSeatNumber());
        }
//        System.out.println("booking for occupied seat: " + ticket2);

        logger.info("Total bookings: " + Booking.getBookings());
        logger.info("-----------------------");

        try (ServiceSession session = new ServiceSession()) {
            airport.getCheckInService().checkIn(ticket1);
        } catch (InvalidTicketException e) {
            logger.error("Check in failed: " + e.getMessage());
        }
        airport.getBoardingService().boardPassenger(ticket1);
        airport.getFlightManagementService().delayFlight(flight, 15);

        ServiceDesk.announce("Boarding begins at Gate 13");
        ServiceDesk desk = new ServiceDesk("Service Desk-01.");
        desk.assistCheckIn(bookingService, ticket1);


        logger.info("----------H6--------------");
        List<Seat> seats = new ArrayList<>(Arrays.asList(seat1, seat2, seat3, seat4));
        Predicate<Seat> freeSeat = s -> !s.isOccupied();
        Function<Passenger, BigDecimal> discount = p -> p.hasDiscount() ? new java.math.BigDecimal("10.13") : java.math.BigDecimal.ZERO;
        Supplier<SeatClass> seatClassSupplier = () -> SeatClass.BUSINESS;
        Consumer<AirportFunctional.PriceBreakdown> breakdownLogger = b -> logger.info(b.toString());
        FareCalculator fareCalculator = (baseFare, passenger, seatClass) -> seatClass.applyTo(baseFare);
        SeatSelector seatSelector = (list, filter) -> list.stream().filter(filter).findFirst().orElse(null);
        FlightAlert notifier = (passenger, flight1, msg) -> logger.info("Notifying " + passenger.getFirstName() + " message: " + msg + " " + FlightStatus.SCHEDULED.getDescription());

        AirportFunctional.PriceBreakdown breakdown = AirportFunctional.processBooking(
                memberPassenger,
                flight,
                seats,
                new java.math.BigDecimal("110.0"),

                freeSeat,
                discount,
                breakdownLogger,
                seatClassSupplier,

                fareCalculator,
                notifier,
                seatSelector
        );

        logger.info("Get Final Price: " + breakdown.getFinalPrice());


        logger.info("----------H7--------------");

        Map<Boolean, List<Seat>> seatsByStatus = seats.stream()
                .collect(Collectors.groupingBy(Seat::isOccupied));
        logger.info("Occupied seats are: " + seatsByStatus.keySet().size());

        OptionalDouble avgPrice = seats.stream()
                .mapToDouble(seat -> seat.getPrice().doubleValue())
                .average();
        logger.info("Average seat price is: " + avgPrice);

        List<String> passengerNames = people.stream()
                .filter(person -> person instanceof Passenger)
                .map(person -> person.getFirstName() + " " + person.getLastName())
                .sorted().toList();
        logger.info("Sorted passenger names are: " + passengerNames);

        boolean hasLargeTransport = transports.stream()
                .anyMatch(transport -> transport.getCapacity() > 400);
        logger.info("Transport with more than 400 capacity exists: " + hasLargeTransport);
    }
}
