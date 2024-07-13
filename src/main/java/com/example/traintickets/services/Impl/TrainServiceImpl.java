package com.example.traintickets.services.Impl;

import com.example.traintickets.entities.Train;
import com.example.traintickets.repositories.TrainRepository;
import com.example.traintickets.services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainRepository trainRepository;

    @Override
    public List<Train> findTrainByRouteIn() {
        return trainRepository.findTrainByRouteIn();
    }
}
