package com.example.traintickets.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "train")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Train extends BaseEntity {
    private String trainNumber;
    private Date departureTime;
    private Date arrivalTime;
    private String route;

    public Train(String trainNumber, Date departureTime, Date arrivalTime, String route) {
        setTrainNumber(trainNumber);
        setDepartureTime(departureTime);
        setArrivalTime(arrivalTime);
        setRoute(route);
    }

    protected Train() {
    }

    @Column(name = "train_number")
    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    @Column(name = "departure_time")
    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }
    @Column(name = "arrival_time")
    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    @Column(name = "route")
    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}