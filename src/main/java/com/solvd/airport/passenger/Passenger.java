package com.solvd.airport.passenger;

import com.solvd.airport.core.Person;
import com.solvd.airport.annotations.Info;

import java.time.LocalDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

    @Info(value = "Passenger", description = "Passenger info")
    public class Passenger extends Person {

        private static final Logger logger = LogManager.getLogger(Passenger.class);

        @Info(value = "passengerId", description = "Unique identifier for the passenger")
        private int passengerId;

        @Info(value = "isPremiumMember", description = "Premium member status")
        private boolean isPremiumMember;

        @Info(value = "Passenger Constructor", description = "Creates a new Passenger instance")
        public Passenger(int passengerId, String firstName, String lastName,
                         String email, String gender, LocalDate birthDate, boolean isPremiumMember) {
            super(firstName, lastName, email, gender, birthDate);
            this.passengerId = passengerId;
            this.isPremiumMember = isPremiumMember;
    }

    @Info(value = "personRole", description = "Role description for the passenger")
    public String personRole() {
        return isPremiumMember ? "Gets a discount" : "Regular price";
    }
    
    @Info(value = "hasDiscount", description = "Checks if passenger has a discount")
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
