package com.example.traintickets.repositories.base;

import com.example.traintickets.entities.BookingStatusEnum;
import com.example.traintickets.entities.Place;
import com.example.traintickets.entities.RailwayCarriage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasePlaceRepository extends JpaRepository<Place, Integer> {
        @Query(value = "SELECT p FROM Place p WHERE p.id = :id")
        List<Place> findById(@Param(value = "id") int id);

        @Query(value = "SELECT p FROM Place p WHERE p.railwayCarriage = :railwayCarriage AND p.bookingStatus = :status")
        List<Place> findByRailwayCarriageAndBookingStatus(@Param(value = "railwayCarriage")
                                                          RailwayCarriage railwayCarriage,
                                                          @Param(value = "status") BookingStatusEnum status);
    }
