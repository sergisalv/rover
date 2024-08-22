package com.example.rover.controllers;

import com.example.rover.dto.ObstacleDto;
import com.example.rover.dto.RoverDto;
import com.example.rover.models.Obstacle;
import com.example.rover.services.ObstacleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ObstacleController {

    @Autowired
    private ObstacleService service;

    @PostMapping("/api/obstacle/")
    public void create(@RequestBody ObstacleDto obstacle){
    }

    @GetMapping ("/api/obstacle/")
    public List<Obstacle> getAll(){
        service.obstacleCreation();
       return service.findAll();

    }
}
