package com.example.traintickets.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "railway_carriage")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class RailwayCarriage extends BaseEntity {
    private int carNumber;
    private Train train;
    private int seatsNumber;
    private CarsTypesEnum carType;

    public RailwayCarriage(int carNumber, Train train, int seatsNumber, CarsTypesEnum carType) {
        setCarNumber(carNumber);
        setTrain(train);
        setSeatsNumber(seatsNumber);
        setCarType(carType);
    }

    protected RailwayCarriage() {
    }

    @Column(name = "car_number", nullable = false)
    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id", referencedColumnName = "id", nullable = false)
    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
    @Column(name = "seats_number")
    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }
    @Column(name = "car_type", nullable = false)
    public CarsTypesEnum getCarType() {
        return carType;
    }

    public void setCarType(CarsTypesEnum carType) {
            this.carType = carType;
    }
}
