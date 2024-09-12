package com.example.traintickets.dtos;

import com.example.traintickets.entities.Passenger;
import com.example.traintickets.entities.Place;
import com.example.traintickets.entities.RailwayCarriage;
import com.example.traintickets.entities.Train;
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
//    private Train train;
//    private RailwayCarriage railwayCarriage;
//    private Place place;
//    private Passenger passenger;
    private float ticketPrice;
    private Date bookingTime;
    private Date paymentTime;
}
