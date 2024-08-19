package com.example.rover.controllers;

import com.example.rover.dto.CommandDto;
import com.example.rover.dto.RoverDto;
import com.example.rover.models.Direction;
import com.example.rover.models.Rover;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoverController {

    @GetMapping ("/api/rover/")
    public Rover get(){
        Rover rover = new Rover();
        rover.setX(5);
        rover.setY(3);
        rover.setDirection(Direction.EAST);
        return rover;
    }

    @PostMapping ("/api/rover/")
    public void create(@RequestBody RoverDto rover){

    }

    @PostMapping ("/api/rover/command/")
    public void create(@RequestBody CommandDto commands){


    }
}
