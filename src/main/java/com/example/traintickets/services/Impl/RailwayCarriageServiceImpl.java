//package com.example.traintickets.services.Impl;
//
//import com.example.traintickets.entities.RailwayCarriage;
//import com.example.traintickets.repositories.RailwayCarriageRepository;
//import com.example.traintickets.services.RailwayCarriageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class RailwayCarriageServiceImpl implements RailwayCarriageService {
//
//    @Autowired
//    private RailwayCarriageRepository railwayCarriageRepository;
//
//    @Override
//    public List<RailwayCarriage> findAllBySeatsNumber(int seatsNumber) {
//        return railwayCarriageRepository.findAllBySeatsNumber(seatsNumber);
//    }
//
//    @Override
//    public List<RailwayCarriage> findRailwayCarriagesByTrainNumber(String trainNumber) {
//        return railwayCarriageRepository.findRailwayCarriagesByTrainNumber(trainNumber);
//    }
//}
