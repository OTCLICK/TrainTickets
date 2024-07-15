package com.example.traintickets.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "passenger")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Passenger extends BaseEntity {
    private String passengerName;
    private String passportDetails;
    private String email;
    private int tripsNumber;

    public Passenger(String passengerName, String passportDetails, String email, int tripsNumber) {
        setPassengerName(passengerName);
        setPassportDetails(passportDetails);
        setEmail(email);
        setTripsNumber(tripsNumber);
    }

    protected Passenger() {
    }

    @Column(name = "passenger_name", nullable = false)
    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    @Column(name = "passport_details", nullable = false)
    public String getPassportDetails() {
        return passportDetails;
    }

    public void setPassportDetails(String passportDetails) {
        this.passportDetails = passportDetails;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "trips_number", nullable = false)
    public int getTripsNumber() {
        return tripsNumber;
    }

    public void setTripsNumber(int tripsNumber) {
        this.tripsNumber = tripsNumber;
    }
}
