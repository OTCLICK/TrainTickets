package com.example.traintickets.dtos;

import com.example.traintickets.entities.BookingStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceDTO {
    private int id;
    private int placeNumber;
    private RailwayCarriageDTO railwayCarriage;
    private BookingStatusEnum bookingStatus;
}
