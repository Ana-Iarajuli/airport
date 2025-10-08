package main.java.com.solvd.airport.core;

import java.time.LocalDate;

public class Employee extends Person {

    private String position;

    public Employee(String firstName, String lastName, String email, String gender, LocalDate birthDate, String position) {
        super(firstName, lastName, email, gender, birthDate);
        this.position = position;
    }

    @Override
    public String personRole() {
        return position;
    }

    @Override
    public boolean hasDiscount() {
        return position.contains("manager");
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
