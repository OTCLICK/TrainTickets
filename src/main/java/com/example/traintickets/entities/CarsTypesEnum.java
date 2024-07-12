package com.example.traintickets.entities;

public enum CarsTypesEnum {
    SEAT_CARRIAGE(1),
    ECONOM_CLASS_TRAIN(2),
    COUPE(3),
    CAR_SV(4),
    RIC(5),
    RESTAURANT_CAR(6),
    STAFF_CAR(7),
    BAGGAGE_CAR(8),
    MAIL_CAR(9);

    private int value;

    CarsTypesEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
