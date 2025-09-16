package flight;

import core.Maintainable;
import core.Trackable;

import java.time.LocalDate;

public class Airplane extends Transport implements Maintainable, Trackable {
    private String model;
    private Seat[] seats;
    private LocalDate lastMaintenanceDate;
    private static final String TRACKING = "TrackingID-";
    private static int nextTrackingNum = 1;
    private final String trackingId;

    public Airplane(String manufacturer, int capacity) {
        super(manufacturer, capacity);
        this.seats = new Seat[100];
        this.trackingId = TRACKING + nextTrackingNum++;
    }

    @Override
    public String getTransportType() {
        return "Airplane";
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public void setSeats(Seat[] seats) {
        this.seats = seats;
    }

    protected String airplaneInfo() {
        return getTransportType() + ": model=" + model + ", seats=" + (seats == null ? 0 : seats.length);
    }

    @Override
    public void scheduleMaintenance(LocalDate date) {
        this.lastMaintenanceDate = date;
    }

    @Override
    public LocalDate getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    @Override
    public String getTrackingId() {
        return trackingId;
    }

    @Override
    public void updateStatus(String status) {
        System.out.println("Airplane with tracking ID: " + trackingId + ", status updated: " + status);
    }
}
