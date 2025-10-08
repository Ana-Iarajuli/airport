package main.java.com.solvd.airport.utils;

import java.util.*;

public class Registry<T> {

    private Map<String, T> items;
    private List<String> registrationOrder;
    private Set<String> activeKeys;

    public Registry() {
        this.items = new HashMap<>();
        this.registrationOrder = new ArrayList<>();
        this.activeKeys = new HashSet<>();
    }

    public boolean registerWithKey(String key, T item) {
        if (key == null || item == null) {
            return false;
        }
        items.put(key, item);
        registrationOrder.add(key);
        activeKeys.add(key);
        System.out.println("Registration was successful with a key: " + key);

        return true;
    }

    public T getFirstItem() {
        if (registrationOrder.isEmpty())  return null;
        String firstKey = registrationOrder.getFirst();
        return items.get(firstKey);
    }

    @Override
    public String toString() {
        return "-----Airport Registry info: " +
                " items in total: " + items.size() +
                " active keys: " + activeKeys.size() +
                " register history: " + registrationOrder.size();
    }
}

