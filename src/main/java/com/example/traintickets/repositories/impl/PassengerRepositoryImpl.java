package com.example.traintickets.repositories.impl;

import com.example.traintickets.entities.Passenger;
import com.example.traintickets.repositories.PassengerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PassengerRepositoryImpl implements PassengerRepository {

    @Autowired
    private BasePassengerRepository basePassengerRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Passenger> findById(int id) {
        return basePassengerRepository.findById(id);
//        return entityManager.createQuery("SELECT p FROM Passenger p WHERE p.id = :id", Passenger.class)
//                .setParameter("id", id)
//                .getResultList();
    }

    @Override
    public List<Passenger> findByEmail(String email) {
        return basePassengerRepository.findByEmail(email);
//        return entityManager.createQuery("SELECT p FROM Passenger p WHERE p.email = :email", Passenger.class)
//                .setParameter("email", email)
//                .getResultList();
    }

    @Override
    public Passenger save(Passenger passenger) {
        if (passenger.getId() == 0) {
            entityManager.persist(passenger);
        } else {
            entityManager.merge(passenger);
        }
        return passenger;
    }

    interface BasePassengerRepository extends JpaRepository<Passenger, Integer> {
        @Query(value = "SELECT p FROM Passenger p WHERE p.id = :id")
        List<Passenger> findById(@Param(value = "id") int id);

        @Query(value = "SELECT p FROM Passenger p WHERE p.email = :email")
        List<Passenger> findByEmail(@Param(value = "email") String email);
    }
}
