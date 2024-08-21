package com.example.rover.services;


import com.example.rover.dto.ObstacleDto;
import com.example.rover.models.Obstacle;
import com.example.rover.repository.ObstacleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObstacleServiceImp implements ObstacleService{

    @Autowired
    private ObstacleRepository repository;

    @Override
    public List<Obstacle> findAll() {
        return repository.findAll();
    }
}
