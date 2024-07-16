package com.example.traintickets.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookingPlaceDTO {
    private int placeId;
    private int passengerId;
    private float ticketPrice;
    private String bookingPlace;
    private Date paymentTime;
}
