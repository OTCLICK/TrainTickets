package com.example.traintickets.repositories.impl;

import com.example.traintickets.entities.BookingStatusEnum;
import com.example.traintickets.entities.Passenger;
import com.example.traintickets.entities.Place;
import com.example.traintickets.entities.RailwayCarriage;
import com.example.traintickets.repositories.BaseRepo;
import com.example.traintickets.repositories.PlaceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaceRepositoryImpl extends BaseRepo<Place> implements PlaceRepository {

//    @Autowired
//    private BasePlaceRepository basePlaceRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public PlaceRepositoryImpl() {
        super(Place.class);
    }

    @Override
    public List<Place> findById(int id) {
//        return basePlaceRepository.findById(id);
        return entityManager.createQuery("SELECT p FROM Place p WHERE p.id = :id", Place.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<Place> findByRailwayCarriageAndBookingStatus(RailwayCarriage railwayCarriage, BookingStatusEnum status) {
//        return basePlaceRepository.findByRailwayCarriageAndBookingStatus(railwayCarriage, status);
        return entityManager.createQuery("SELECT p FROM Place p WHERE p.railwayCarriage = :railwayCarriage AND p.bookingStatus = :status", Place.class)
                .setParameter("railwayCarriage", railwayCarriage)
                .setParameter("status", status)
                .getResultList();
    }

//    @Override
//    public Place save(Place place) {
//        if (place.getId() == 0) {
//            entityManager.persist(place);
//        } else {
//            entityManager.merge(place);
//        }
//        return place;
//    }

//    @Repository
//    interface BasePlaceRepository extends JpaRepository<Place, Integer> {
//        @Query(value = "SELECT p FROM Place p WHERE p.id = :id")
//        List<Place> findById(@Param(value = "id") int id);
//
//        @Query(value = "SELECT p FROM Place p WHERE p.railwayCarriage = :railwayCarriage AND p.bookingStatus = :status")
//        List<Place> findByRailwayCarriageAndBookingStatus(@Param(value = "railwayCarriage")
//                                                          RailwayCarriage railwayCarriage,
//                                                          @Param(value = "status") BookingStatusEnum status);
//    }
}
