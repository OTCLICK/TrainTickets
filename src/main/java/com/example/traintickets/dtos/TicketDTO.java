package com.example.traintickets.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TicketDTO {
    private int id;
    private TrainDTO train;
    private RailwayCarriageDTO railwayCarriage;
    private PlaceDTO place;
    private PassengerDTO passenger;
    private float ticketPrice;
    private Date bookingTime;
    private Date paymentTime;
}
