package com.example.traintickets.services;

import com.example.traintickets.entities.BookingStatusEnum;
import com.example.traintickets.entities.CarsTypesEnum;
import com.example.traintickets.entities.Place;

import java.util.List;

public interface PlaceService {

    void addPlace(Place place);

    List<Place> findAllByBookingStatus(BookingStatusEnum bookingStatus);

    List<Place> findPlacesByCarType(CarsTypesEnum carType);
}
