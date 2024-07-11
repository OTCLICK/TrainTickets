package com.example.traintickets.repositories;

import com.example.traintickets.entities.RailwayCarriage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RailwayCarriageRepository extends CrudRepository<RailwayCarriage, Integer> {

    //Search carriages that could accommodate the specified number of passengers
    @Query(value = "SELECT rc FROM RailwayCarriage rc WHERE rc.seatsNumber > :seatsNumber")
    List<RailwayCarriage> findAllBySeatsNumber(@Param(value = "seats_number") int seatsNumber);

    //Search cars of a specific train
    @Query("SELECT rc FROM RailwayCarriage rc JOIN rc.train tr WHERE tr.trainNumber = :trainNumber")
    List<RailwayCarriage> findRailwayCarriagesByTrainNumber(@Param("train_number") String trainNumber);
}
