package com.example.traintickets.repositories.impl;

import com.example.traintickets.entities.Train;
import com.example.traintickets.repositories.TrainRepository;
import com.example.traintickets.repositories.base.BaseTrainRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainRepositoryImpl implements TrainRepository {

    @Autowired
    private BaseTrainRepository baseTrainRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Train> findById(int id) {
        return baseTrainRepository.findById(id);
//        return entityManager.createQuery("SELECT t FROM Train t WHERE t.id = :id", Train.class)
//                .setParameter("id", id)
//                .getResultList();
    }

    @Override
    public Train save(Train train) {
        if (train.getId() == 0) {
            entityManager.persist(train);
        } else {
            entityManager.merge(train);
        }
        return train;
    }

//    @Repository
//    interface BaseTrainRepository extends JpaRepository<Train, Integer> {
//        @Query(value = "SELECT t FROM Train t WHERE t.id = :id")
//        List<Train> findById(@Param(value = "id") int id);
//    }
}
