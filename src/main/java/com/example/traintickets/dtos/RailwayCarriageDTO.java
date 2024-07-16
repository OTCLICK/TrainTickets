package com.example.traintickets.dtos;

import com.example.traintickets.entities.CarsTypesEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RailwayCarriageDTO {
    private int id;
    private int carNumber;
    private TrainDTO train;
    private int seatsNumber;
    private CarsTypesEnum carType;
}
