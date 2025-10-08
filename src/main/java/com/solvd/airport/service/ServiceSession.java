package main.java.com.solvd.airport.service;

public class ServiceSession implements AutoCloseable {

    private boolean open;

    public ServiceSession() {
        this.open = true;
        System.out.println("Service session is open");
    }

    @Override
    public void close() {
        open = false;
        System.out.println("Service session is closed");
    }
}


