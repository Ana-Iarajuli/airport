package main.java.com.solvd.airport.utils;

import main.java.com.solvd.airport.flight.Seat;
import main.java.com.solvd.airport.passenger.Passenger;
import main.java.com.solvd.airport.service.Booking;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ServiceManager<T> {

    private List<T> processedItems;
    private Set<T> services;
    private Queue<T> priorityQueue;
    private Queue<T> regularQueue;
    private Map<String, T> namedServices;

    private Predicate<Passenger> hasValidCredentials = p -> p.getEmail() != null;
    private Consumer<Booking> bookingNotifier = b -> System.out.println("Booking confirmed");
    private Predicate<Seat> freeSeat = s -> !s.isOccupied();
    private Consumer<main.java.com.solvd.airport.utils.AirportFunctional.PriceBreakdown> logger = b -> System.out.println("AUDIT: " + b);


    public ServiceManager() {
        this.priorityQueue = new ArrayDeque<>();
        this.regularQueue = new ArrayDeque<>();
        this.processedItems = new ArrayList<>();
        this.services = new HashSet<>();
        this.namedServices = new HashMap<>();
    }

    public boolean addToPriority(T service) {
        if (service == null) return false;
        services.add(service);
        return priorityQueue.offer(service);
    }

    public boolean addToRegular(T service) {
        if (service == null) return false;
        services.add(service);
        return regularQueue.offer(service);
    }

    public void addNamedService(String name, T service) {
        if (name != null && service != null) {
            namedServices.put(name, service);
            services.add(service);
        }
    }

    @Override
    public String toString() {
        return "-----Airport Service Manager: " +
                " Priority queue: " + priorityQueue.size() +
                " Regular queue: " + regularQueue.size() +
                " Services: " + services.size() +
                " processed items: " + processedItems.size();
    }
}
