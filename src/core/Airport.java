package core;

import flight.Transport;
import service.CheckInService;
import service.BoardingService;
import service.FlightManagementService;

public class Airport {

    private String airportName;
    private Terminal[] terminals;
    private Transport[] transports;
    private CheckInService checkInService;
    private BoardingService boardingService; 
    private FlightManagementService flightManagementService; 
    public Airport(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public Terminal[] getTerminals() {
        return terminals;
    }

    public void setTerminals(Terminal[] terminals) {
        this.terminals = terminals;
    }

    public Transport[] getTransports() {
        return transports;
    }

    public void setTransports(Transport[] transports) {
        this.transports = transports;
    }

    public void setCheckInService(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    public CheckInService getCheckInService() {
        return checkInService;
    }

    public BoardingService getBoardingService() {
        return boardingService;
    }

    public void setBoardingService(BoardingService boardingService) {
        this.boardingService = boardingService;
    }

    public FlightManagementService getFlightManagementService() {
        return flightManagementService;
    }

    public void setFlightManagementService(FlightManagementService flightManagementService) {
        this.flightManagementService = flightManagementService;
    }
}
