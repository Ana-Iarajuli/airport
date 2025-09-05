import core.*;
import flight.*;
import passenger.*;
import service.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MainClass {

    public static void main(String[] args) {

        Airport airport = new Airport("Tatooine airport");
        System.out.println(airport.getAirportName());

        Terminal t1 = new Terminal(1);
        Terminal t2 = new Terminal(2);

        airport.getTerminals()[0] = t1;
        airport.getTerminals()[1] = t2;

        Gate gate1 = new Gate(19);
        Gate gate2 = new Gate(13);
        Gate gate3 = new Gate(3);

        Airline airline = new Airline("Fly with Yoda");

        Seat seat1 = new Seat("23B", true);
        seat1.setPrice(new BigDecimal("123.4"));
        Seat seat2 = new Seat("3C", false);
        seat2.setPrice(new BigDecimal("119.4"));
        Seat seat3 = new Seat("28B", true);
        seat3.setPrice(new BigDecimal("123.4"));
        Seat seat4 = new Seat("13A", false);
        seat4.setPrice(new BigDecimal("119.4"));

        Passenger passenger1 = new Passenger(1, "Obi-wan", "Kenobi", "test@test.com");
        Passenger passenger2 = new Passenger(1, "Luke", "Skywalker", "dark@side.com");
        Passenger passenger3 = new Passenger(1, "Darth", "Vader", "iAmLuke@lovePadme.com");

        Flight flight = new Flight(1, "Death Star",
                LocalDateTime.of(2024, 12, 16, 14, 0),
                LocalDateTime.of(2024, 12, 16, 20, 30)
                );

    }
}
