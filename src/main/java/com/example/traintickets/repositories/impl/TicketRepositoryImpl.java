package com.example.traintickets.repositories.impl;

import com.example.traintickets.entities.Passenger;
import com.example.traintickets.entities.Ticket;
import com.example.traintickets.repositories.TicketRepository;
import com.example.traintickets.repositories.base.BaseTicketRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketRepositoryImpl implements TicketRepository {

    @Autowired
    private BaseTicketRepository baseTicketRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Ticket> findById(int id) {
        return baseTicketRepository.findById(id);
//        return entityManager.createQuery("SELECT t FROM Ticket t WHERE t.id = :id", Ticket.class)
//                .setParameter("id", id)
//                .getResultList();
    }

    @Override
    public List<Ticket> findByPassenger(Passenger passenger) {
        return baseTicketRepository.findByPassenger(passenger);
//        return entityManager.createQuery("SELECT t FROM Ticket t WHERE t.passenger = :passenger", Ticket.class)
//                .setParameter("passenger", passenger)
//                .getResultList();
    }

    @Override
    public Ticket save(Ticket ticket) {
        if (ticket.getId() == 0) {
            entityManager.persist(ticket);
        } else {
            entityManager.merge(ticket);
        }
        return ticket;
    }

//    @Repository
//    interface BaseTicketRepository extends JpaRepository<Ticket, Integer> {
//        @Query(value = "SELECT t FROM Ticket t WHERE t.id = :id")
//        List<Ticket> findById(@Param(value = "id") int id);
//
//        @Query(value = "SELECT t FROM Ticket t WHERE t.passenger = :passenger")
//        List<Ticket> findByPassenger(@Param(value = "passenger") Passenger passenger);
//    }
}
