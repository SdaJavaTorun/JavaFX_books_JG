package sample.model;

import javafx.beans.property.*;

import java.time.LocalDate;


public class Person {

    private  StringProperty firstName;
    private  StringProperty lastName;
    private StringProperty street;
    private StringProperty postalCode;
    private StringProperty city;
    private ObjectProperty<LocalDate> birthdate;

    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

    }

    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.street = builder.street;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public String getPostalCode() {
        return postalCode.get();
    }

    public StringProperty postalCodeProperty() {
        return postalCode;
    }

    public String getCity() {
        return city.get();
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public void setPostalCode(String postalCode) {
        this.postalCode.set(postalCode);
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate.set(birthdate);
    }

    public StringProperty cityProperty() {
        return city;
    }

    public LocalDate getBirthdate() {
        return birthdate.get();
    }

    public ObjectProperty<LocalDate> birthdateProperty() {
        return birthdate;
    }

    public static final class Builder {
        private final  StringProperty firstName;
        private final StringProperty lastName;
        private StringProperty street;
        private StringProperty postalCode;
        private StringProperty city;
        private ObjectProperty<LocalDate> birthdate;

        public Builder(String firstName, String lastName) {
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
        }

        public Builder street(String val) {
            this.street = new SimpleStringProperty(val);
            return this;
        }

        public Builder city(String val) {
            this.city = new SimpleStringProperty(val);
            return this;
        }
        public Builder postalCode(String val) {
            this.postalCode = new SimpleStringProperty(val);
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}


