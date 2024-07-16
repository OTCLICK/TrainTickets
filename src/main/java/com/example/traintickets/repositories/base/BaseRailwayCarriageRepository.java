package com.example.traintickets.repositories.base;

import com.example.traintickets.entities.RailwayCarriage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseRailwayCarriageRepository extends JpaRepository<RailwayCarriage, Integer> {
    @Query(value = "SELECT r FROM RailwayCarriage r WHERE r.id = :id")
    List<RailwayCarriage> findById(@Param(value = "id") int id);
}

