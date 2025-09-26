package passenger;

import java.time.LocalDate;

public record PassengerRecord(int id, String firstName, String Lastname, String email,
                              String gender, LocalDate birthDate, boolean premiumMember) { }

