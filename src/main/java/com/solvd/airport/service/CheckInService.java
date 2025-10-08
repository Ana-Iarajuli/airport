package main.java.com.solvd.airport.service;

import main.java.com.solvd.airport.passenger.Ticket;
import main.java.com.solvd.airport.exceptions.InvalidTicketException;

public interface CheckInService {

    boolean checkIn(Ticket ticket) throws InvalidTicketException;
}


