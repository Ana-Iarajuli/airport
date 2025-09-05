package core;

public class Airport {

    private String airportName;

    public Airport(String airportName) {
        this.airportName = airportName;
    }
    private Terminal[] terminals;

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
}
