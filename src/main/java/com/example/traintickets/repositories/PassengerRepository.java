package com.example.traintickets.repositories;

import com.example.traintickets.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository {

//    @Query(value = "SELECT p FROM Passenger p WHERE p.id = :id")
//    List<Passenger> findById(@Param(value = "id") int id);
//
//    @Query(value = "SELECT p FROM Passenger p WHERE p.email = :email")
//    List<Passenger> findByEmail(@Param(value = "email") String email);

    List<Passenger> findById(int id);

    List<Passenger> findByEmail(String email);

    void save(Passenger passenger);

    void update(Passenger passenger);

//    Passenger save(Passenger passenger);

//    //Search passengers to verify their purchase of train tickets
//    @Query(value = "SELECT p FROM Passenger p " +
//            "WHERE p.passengerName = :passengerName AND p.passportDetails = :passportDetails")
//    List<Passenger> findAllByPassengerNameAndPassportDetails(@Param(value = "passenger_name") String passengerName,
//                                                             @Param(value = "passport_details") String passportDetails);
}
