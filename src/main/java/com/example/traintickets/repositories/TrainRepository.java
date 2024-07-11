package com.example.traintickets.repositories;

import com.example.traintickets.entities.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {

    List<Train> findAllByTrainNumber(String trainNumber);

    //Search trains going to Voronezh
    @Query(value = "SELECT t FROM Train t WHERE t.route IN 'Москва - Воронеж'")
    List<Train> findTrainByRouteIn();
}
