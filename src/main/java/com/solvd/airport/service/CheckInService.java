package com.solvd.airport.service;

import com.solvd.airport.passenger.Ticket;
import com.solvd.airport.exceptions.InvalidTicketException;

public interface CheckInService {

    boolean checkIn(Ticket ticket) throws InvalidTicketException;
}


