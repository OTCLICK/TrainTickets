package com.example.traintickets.repositories;

import com.example.traintickets.entities.RailwayCarriage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RailwayCarriageRepository extends CrudRepository<RailwayCarriage, Integer> {
}
