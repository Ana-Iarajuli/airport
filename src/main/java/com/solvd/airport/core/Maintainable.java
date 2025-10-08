package main.java.com.solvd.airport.core;

import java.time.LocalDate;

public interface Maintainable {

    void scheduleMaintenance(LocalDate date);

    LocalDate getLastMaintenanceDate();
}


