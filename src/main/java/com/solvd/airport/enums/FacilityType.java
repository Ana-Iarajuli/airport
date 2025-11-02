package com.solvd.airport.enums;

public enum FacilityType {

    LOUNGE("Relax, take it easy", 8),
    RESTROOM("Tywin Lannister's favorite place", 10),
    SHOP("Overpriced things", 6),
    FOOD("Overpriced but necessary", 9),
    SECURITY_CHECK("Security", 10);

    private final String description;
    private final int popularity;

    FacilityType(String description, int popularity) {
        this.description = description;
        this.popularity = popularity;
    }

    public String getDescription() { return description; }

    public int getPopularity() { return popularity; }

    public boolean isEssential() {
        return this == RESTROOM || this == SECURITY_CHECK || this == FOOD;
    }
}

