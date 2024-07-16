package com.example.traintickets.repositories.base;

import com.example.traintickets.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasePassengerRepository extends JpaRepository<Passenger, Integer> {
    @Query(value = "SELECT p FROM Passenger p WHERE p.id = :id")
    List<Passenger> findById(@Param(value = "id") int id);

    @Query(value = "SELECT p FROM Passenger p WHERE p.email = :email")
    List<Passenger> findByEmail(@Param(value = "email") String email);
}
