package com.example.rover.services;

import com.example.rover.dto.ObstacleDto;
import com.example.rover.models.Obstacle;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ObstacleService {
    public void obstacleCreation();
    public List<Obstacle> findAll();
}
