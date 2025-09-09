package core;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Person {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private LocalDate birthDate;

    public Person(String firstName, String lastName, String email, String gender, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public abstract String personRole();
    public abstract boolean hasDiscount();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    protected String fullName() {
        return firstName + " " + lastName;
    }


    @Override
    public String toString() {
        return "Person info:" +
                "name - " + fullName() +
                ", email - " + email +
                ", role - " + personRole();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }

        Person person = (Person) obj;
        return person.getFirstName().equals(firstName) &&
                person.getLastName().equals(lastName) &&
                person.getEmail().equals(email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email);
    }
}
