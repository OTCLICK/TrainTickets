package com.example.traintickets.repositories.impl;

import com.example.traintickets.entities.RailwayCarriage;
import com.example.traintickets.repositories.RailwayCarriageRepository;
import com.example.traintickets.repositories.base.BaseRailwayCarriageRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RailwayCarriageRepositoryImpl implements RailwayCarriageRepository {

    @Autowired
    private BaseRailwayCarriageRepository baseRailwayCarriageRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RailwayCarriage> findById(int id) {
        return baseRailwayCarriageRepository.findById(id);
//        return entityManager.createQuery("SELECT r FROM RailwayCarriage r WHERE r.id = :id", RailwayCarriage.class)
//                .setParameter("id", id)
//                .getResultList();
    }

    @Override
    public RailwayCarriage save(RailwayCarriage railwayCarriage) {
        if (railwayCarriage.getId() == 0) {
            entityManager.persist(railwayCarriage);
        } else {
            entityManager.merge(railwayCarriage);
        }
        return railwayCarriage;
    }

//    @Repository
//    interface BaseRailwayCarriageRepository extends JpaRepository<RailwayCarriage, Integer> {
//        @Query(value = "SELECT r FROM RailwayCarriage r WHERE r.id = :id")
//        List<RailwayCarriage> findById(@Param(value = "id") int id);
//    }
}
