package com.solvd.airport.passenger;

import com.solvd.airport.core.Person;

import java.time.LocalDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Passenger extends Person {

    private static final Logger logger = LogManager.getLogger(Passenger.class);
    
    private int passengerId;
    private boolean isPremiumMember;


    public Passenger(int passengerId, String firstName, String lastName,
                     String email, String gender, LocalDate birthDate, boolean isPremiumMember) {
        super(firstName, lastName, email, gender, birthDate);
        this.passengerId = passengerId;
        this.isPremiumMember = isPremiumMember;
    }

    public String personRole() {
        return isPremiumMember ? "Gets a discount" : "Regular price";
    }
    public boolean hasDiscount() { return isPremiumMember; }

    public static class Passport {
        private String passportNumber;
    }

    protected void printPassportInfo(Passport passport) {
        logger.info("Passport number is: " + passport.passportNumber);
    }

    public int getPassengerId() {return passengerId;}

    public void setPassengerId(int passengerId) {this.passengerId = passengerId;}
}
