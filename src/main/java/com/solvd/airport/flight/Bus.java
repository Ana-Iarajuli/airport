package main.java.com.solvd.airport.flight;

public class Bus extends Transport {
    public Bus(String manufacturer, int capacity) {
        super(manufacturer, capacity);
    }

    @Override
    public String getTransportType() {
        return "Airport Bus";
    }
}
