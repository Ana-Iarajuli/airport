package passenger;

import core.Person;

import java.time.LocalDate;

public class Passenger extends Person {

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

    public void printPassportInfo(Passport passport) {
        System.out.println("Passport number is: " + passport.passportNumber);
    }

    public int getPassengerId() {return passengerId;}

    public void setPassengerId(int passengerId) {this.passengerId = passengerId;}
}
