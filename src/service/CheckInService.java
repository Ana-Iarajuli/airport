package service;

import passenger.Ticket;
import exceptions.InvalidTicketException;

public interface CheckInService {

    boolean checkIn(Ticket ticket) throws InvalidTicketException;
}


