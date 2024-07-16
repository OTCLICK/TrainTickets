package com.example.traintickets.repositories.base;

import com.example.traintickets.entities.Passenger;
import com.example.traintickets.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseTicketRepository extends JpaRepository<Ticket, Integer> {
    @Query(value = "SELECT t FROM Ticket t WHERE t.id = :id")
    List<Ticket> findById(@Param(value = "id") int id);

    @Query(value = "SELECT t FROM Ticket t WHERE t.passenger = :passenger")
    List<Ticket> findByPassenger(@Param(value = "passenger") Passenger passenger);
}
