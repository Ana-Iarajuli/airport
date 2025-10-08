package main.java.com.solvd.airport.flight;

import java.math.BigDecimal;

public class Seat {

    private String seatNumber;
    private boolean isOccupied;
    private BigDecimal price;

    public Seat(String seatNumber, boolean isOccupied) {
        this.seatNumber = seatNumber;
        this.isOccupied = isOccupied;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
