package com.example.traintickets.repositories.base;

import com.example.traintickets.entities.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseTrainRepository extends JpaRepository<Train, Integer> {
    @Query(value = "SELECT t FROM Train t WHERE t.id = :id")
    List<Train> findById(@Param(value = "id") int id);
}
