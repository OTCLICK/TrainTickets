//package com.example.traintickets.services.Impl;
//
//import com.example.traintickets.entities.BookingStatusEnum;
//import com.example.traintickets.entities.CarsTypesEnum;
//import com.example.traintickets.entities.Place;
//import com.example.traintickets.repositories.PlaceRepository;
//import com.example.traintickets.services.PlaceService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class PlaceServiceImpl implements PlaceService {
//
//    @Autowired
//    private PlaceRepository placeRepository;
//
//    @Override
//    public void addPlace(Place place) {
//        placeRepository.save(place);
//    }
//
//    @Override
//    public List<Place> findAllByBookingStatus(BookingStatusEnum bookingStatus) {
//        return placeRepository.findAllByBookingStatus(bookingStatus);
//    }
//
//    @Override
//    public List<Place> findPlacesByCarType(CarsTypesEnum carType) {
//        return placeRepository.findPlacesByCarType(carType);
//    }
//}
