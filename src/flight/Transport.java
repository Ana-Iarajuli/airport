package flight;

import core.Person;

import java.util.Objects;

public abstract class Transport {

    protected String manufacturer;
    protected int capacity;

    public Transport(String manufacturer, int capacity) {
        this.manufacturer = manufacturer;
        this.capacity = capacity;
    }

    public abstract String getTransportType();

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return getTransportType() + ", manufacturer: " + manufacturer + ", capacity: " + capacity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Transport transport = (Transport) obj;
        return transport.getManufacturer().equals(manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer);
    }
}
