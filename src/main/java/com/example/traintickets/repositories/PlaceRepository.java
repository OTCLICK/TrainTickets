package com.example.traintickets.repositories;

import com.example.traintickets.entities.Place;
import org.springframework.data.repository.CrudRepository;

public interface PlaceRepository extends CrudRepository<Place, Integer> {
}
