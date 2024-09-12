package com.example.traintickets.repositories;

import com.example.traintickets.entities.CarsTypesEnum;
import com.example.traintickets.entities.Passenger;
import com.example.traintickets.entities.Place;
import com.example.traintickets.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository {

//    @Query(value = "SELECT t FROM Ticket t WHERE t.id = :id")
//    List<Ticket> findById(@Param(value = "id") int id);
//
//    @Query(value = "SELECT t FROM Ticket t WHERE t.passenger = :passenger")
//    List<Ticket> findByPassenger(@Param(value = "passenger") Passenger passenger);

    List<Ticket> findById(int id);

    List<Ticket> findByPassenger(Passenger passenger);

    void save(Ticket ticket);

    void update(Ticket ticket);

//    Ticket save(Ticket ticket);

//    List<Ticket> findAllByPlace(Place place);
//
//    //Search tickets with preferential discounts
//    @Query(value = "SELECT t FROM Ticket t WHERE t.ticketPrice = :ticketPrice")
//    List<Ticket> findAllByTicketPrice(@Param(value = "ticket_price") float ticketPrice);
//
//    //Search tickets for a specific date
//    @Query("SELECT t FROM Ticket t JOIN t.train tr WHERE tr.departureTime = :departureTime")
//    List<Ticket> findTicketsByDepartureTime(@Param("departure_time") Date departureTime);
}
