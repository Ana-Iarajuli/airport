package core;

import flight.Transport;

public class Airport {

    private String airportName;
    private Terminal[] terminals;
    private Transport[] transports;

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
}
