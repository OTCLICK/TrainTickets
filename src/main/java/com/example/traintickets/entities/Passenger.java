package com.example.traintickets.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "passenger")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Passenger extends BaseEntity {
    private String passengerName;
    private String passportDetails;
    private String email;

    public Passenger(String passengerName, String passportDetails, String email) {
        setPassengerName(passengerName);
        setPassportDetails(passportDetails);
        setEmail(email);
    }

    protected Passenger() {
    }

    @Column(name = "passenger_name")
    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    @Column(name = "passport_details")
    public String getPassportDetails() {
        return passportDetails;
    }

    public void setPassportDetails(String passportDetails) {
        this.passportDetails = passportDetails;
    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
