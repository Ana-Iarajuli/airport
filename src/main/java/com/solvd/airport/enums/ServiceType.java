package com.solvd.airport.enums;

import java.util.Locale;

public enum ServiceType {

    CHECK_IN("Check-in"),
    BOARDING("Boarding"),
    FLIGHT_MANAGEMENT("Flight Management"),
    CUSTOMER_SUPPORT("Customer Support");

    private final String displayName;

    ServiceType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() { return displayName; }

    public String upper() { return displayName.toUpperCase(Locale.ROOT); }

}

