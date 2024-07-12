package com.example.traintickets.entities;

public enum BookingStatusEnum {
    FREE(1),
    BOOKED(2),
    BUSY(3);

    private final int value;

    BookingStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
