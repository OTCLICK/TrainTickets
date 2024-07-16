//package com.example.traintickets.services.Impl;
//
//import com.example.traintickets.entities.Passenger;
//import com.example.traintickets.repositories.PassengerRepository;
//import com.example.traintickets.services.PassengerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class PassengerServiceImpl implements PassengerService {
//
//    @Autowired
//    private PassengerRepository passengerRepository;
//
//    @Override
//    public void addPassenger(Passenger passenger) {
//        passengerRepository.save(passenger);
//    }
//
//    @Override
//    public List<Passenger> findAllByPassengerNameAndPassportDetails(String passengerName, String passportDetails) {
//        return passengerRepository.findAllByPassengerNameAndPassportDetails(passengerName, passportDetails);
//    }
//}
