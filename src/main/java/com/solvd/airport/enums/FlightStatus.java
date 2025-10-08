package main.java.com.solvd.airport.enums;

import java.util.HashMap;
import java.util.Map;

public enum FlightStatus {

    SCHEDULED("SCH", "Flight is scheduled"),
    BOARDING("BRD", "Passengers are boarding"),
    DEPARTED("DEP", "Flight has departed"),
    DELAYED("DLY", "Flight is delayed"),
    CANCELLED("CNL", "Flight is cancelled");

    private final String code;
    private final String description;

    private static final Map<String, FlightStatus> codeIndex = new HashMap<>();

    static {
        for (FlightStatus status : values()) {
            codeIndex.put(status.code, status);
        }
    }

    FlightStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return this == SCHEDULED || this == BOARDING || this == DEPARTED || this == DELAYED;
    }

    public static FlightStatus byCode(String code) {
        return codeIndex.getOrDefault(code, SCHEDULED);
    }
}

