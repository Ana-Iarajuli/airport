package passenger;

public class Passenger {

    private int passengerId;
    private String passengerName;
    private String passengerSurname;
    private String passengerEmail;

    public Passenger(int passengerId, String passengerName, String passengerSurname,
                     String passengerEmail) {
        this.passengerId = passengerId;
        this.passengerName= passengerName;
        this.passengerSurname = passengerSurname;
        this.passengerEmail = passengerEmail;
    }

    public static class Passport {
        private String passportNumber;
    }

    public void printPassportInfo(Passport passport) {
        System.out.println("Passport number is: " + passport.passportNumber);
    }

    public int getPassengerId() {return passengerId;}

    public void setPassengerId(int passengerId) {this.passengerId = passengerId;}

    public String getPassengerName() {return passengerName;}

    public void setPassengerName(String passengerName) {this.passengerName = passengerName;}

    public String getPassengerSurname() {return passengerSurname;}

    public void setPassengerSurname(String passengerSurname) {this.passengerSurname = passengerSurname;}

    public String getPassengerEmail() {return passengerEmail;}

    public void setPassengerEmail(String passengerEmail) {this.passengerEmail = passengerEmail;}
}
