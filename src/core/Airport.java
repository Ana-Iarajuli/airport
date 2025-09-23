package core;

import flight.Transport;
import service.CheckInService;
import service.BoardingService;
import service.FlightManagementService;

import java.util.ArrayList;
import java.util.List;

public class Airport {

    private String airportName;
    private List<Terminal> terminals;
    private List<Transport> transports;
    private CheckInService checkInService;
    private BoardingService boardingService; 
    private FlightManagementService flightManagementService;


    public Airport(String airportName) {
        this.airportName = airportName;
        this.terminals = new ArrayList<>();
        this.transports = new ArrayList<>();
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public boolean addTerminal(Terminal terminal) {
        if (terminal == null) return false;
        return terminals.add(terminal);
    }

    public boolean removeTerminal(Terminal terminal) {
        return terminals.remove(terminal);
    }

    public Terminal getTerminal(int index) {
        if (terminals == null || terminals.isEmpty()) return null;
        if (index < 0 || index >= terminals.size()) return null;
        return terminals.get(index);
    }

    public List<Terminal> getTerminals() { return new ArrayList<>(terminals); }
    
    public void setTerminals(List<Terminal> terminals) { this.terminals = new ArrayList<>(terminals); }

    public List<Transport> getTransports() { return new ArrayList<>(transports); }

    public void setTransports(List<Transport> transports) { this.transports = new ArrayList<>(transports); }

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
