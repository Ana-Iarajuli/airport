package flight;

public class Airplane extends Transport {
    private String model;
    private Seat[] seats;

    public Airplane(String manufacturer, int capacity) {
        super(manufacturer, capacity);
        this.seats = new Seat[100];
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
}
