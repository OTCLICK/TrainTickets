package com.example.traintickets.repositories;

import com.example.traintickets.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository {

//    @Query(value = "SELECT p FROM Place p WHERE p.id = :id")
//    List<Place> findById(@Param(value = "id") int id);
//
//    @Query("SELECT p FROM Place p WHERE p.railwayCarriage = :railwayCarriage AND p.bookingStatus = :status")
//    List<Place> findByRailwayCarriageAndBookingStatus(@Param(value = "railwayCarriage") RailwayCarriage railwayCarriage,
//                                                      @Param(value = "status") BookingStatusEnum status);

    List<Place> findById(int id);

    List<Place> findByRailwayCarriageAndBookingStatus(RailwayCarriage carriage, BookingStatusEnum bookingStatus);

    void save(Place place);

    void update(Place place);

//    Place save(Place place);


//    List<Place> findAllByRailwayCarriage(RailwayCarriage railwayCarriage);
//
//    //Search free/booked/occupied seats
//    @Query(value = "SELECT p FROM Place p WHERE p.bookingStatus = :bookingStatus")
//    List<Place> findAllByBookingStatus(@Param(value = "booking_status") BookingStatusEnum bookingStatus);
//
//    //Search seats on a specific type of carriage
//    @Query("SELECT p FROM Place p JOIN p.railwayCarriage rc WHERE rc.carType = :carType")
//    List<Place> findPlacesByCarType(@Param("car_type") CarsTypesEnum carType);
}
