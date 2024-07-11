package com.example.traintickets.repositories;

import com.example.traintickets.entities.BookingStatusEnum;
import com.example.traintickets.entities.CarsTypesEnum;
import com.example.traintickets.entities.Place;
import com.example.traintickets.entities.RailwayCarriage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Integer> {

    List<Place> findAllByRailwayCarriage(RailwayCarriage railwayCarriage);

    //Search free/booked/occupied seats
    @Query(value = "SELECT p FROM Place p WHERE p.bookingStatus = :bookingStatus")
    List<Place> findAllByBookingStatus(@Param(value = "booking_status") BookingStatusEnum bookingStatus);

    //Search seats on a specific type of carriage
    @Query("SELECT p FROM Place p JOIN p.railwayCarriage rc WHERE rc.carType = :carType")
    List<Place> findPlacesByCarType(@Param("car_type") CarsTypesEnum carType);
}
