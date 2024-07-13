package com.example.traintickets.services;

import com.example.traintickets.entities.RailwayCarriage;

import java.util.List;

public interface RailwayCarriageService {

    List<RailwayCarriage> findAllBySeatsNumber(int seatsNumber);

    List<RailwayCarriage> findRailwayCarriagesByTrainNumber(String trainNumber);
}
