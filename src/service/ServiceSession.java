package service;

import exceptions.ServiceUnavailableRuntimeException;

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


