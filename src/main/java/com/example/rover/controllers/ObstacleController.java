package com.example.rover.controllers;

import com.example.rover.dto.ObstacleDto;
import com.example.rover.dto.RoverDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObstacleController {
    @PostMapping("/api/obstacle/")
    public void create(@RequestBody ObstacleDto obstacle){
    }
}
