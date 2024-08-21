package com.example.rover.services;

import com.example.rover.models.Rover;
import com.example.rover.repository.RoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoverServiceImp implements RoverService{

    @Autowired
    RoverRepository repository;

    @Override
    public Rover get() {
        List<Rover> roverList =  repository.findAll();
        return roverList.get(0);
    }
}
