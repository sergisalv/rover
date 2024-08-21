package com.example.rover.controllers;

import com.example.rover.dto.CommandDto;
import com.example.rover.dto.RoverDto;
import com.example.rover.models.Direction;
import com.example.rover.models.Rover;
import com.example.rover.services.RoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoverController {

    @Autowired
    RoverService service;

    @GetMapping ("/api/rover/")
    public Rover get(){
        return service.get();
    }

    @PostMapping ("/api/rover/")
    public void create(@RequestBody RoverDto rover){

    }

    @PostMapping ("/api/rover/command/")
    public void sendCommand(@RequestBody CommandDto commands){

        String command = commands.getCommands().get(0);

        service.sendCommand(command);


        }




}
