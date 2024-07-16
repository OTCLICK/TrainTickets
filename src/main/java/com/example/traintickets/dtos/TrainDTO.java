package com.example.traintickets.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TrainDTO {
    private int id;
    private String trainNumber;
    private Date departureTime;
    private Date arrivalTime;
    private String route;
}
