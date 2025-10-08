package main.java.com.solvd.airport.flight;

import java.time.LocalDateTime;

public class Flight {

    private int flightId;
    private String destination;
    private LocalDateTime departure;
    private LocalDateTime arrival;

    public Flight(int flightId, String destination, LocalDateTime departure, LocalDateTime arrival) {
        this.flightId = flightId;
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }
}
