package com.example.traintickets.repositories;

import com.example.traintickets.entities.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository {

    @Query(value = "SELECT t FROM Train t WHERE t.id = :id")
    List<Train> findById(@Param(value = "id") int id);

    Train save(Train train);

//    List<Train> findAllByTrainNumber(String trainNumber);
//
//    //Search trains going to Voronezh
//    @Query(value = "SELECT t FROM Train t WHERE t.route IN 'Москва - Воронеж'")
//    List<Train> findTrainByRouteIn();
}
