package com.example.rover.services;


import com.example.rover.dto.ObstacleDto;
import com.example.rover.models.Obstacle;
import com.example.rover.repository.ObstacleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ObstacleServiceImp implements ObstacleService{

    @Autowired
    private ObstacleRepository repository;

    private Obstacle obstacle ;

    @Override
    public void obstacleCreation() {
        repository.deleteAll();
        List<Obstacle> list = new ArrayList<>();
        Random randomNumbers = new Random();

        for (int i = 0; i<5 ; i++){
            obstacle = new Obstacle();
            int randomX = randomNumbers.nextInt(10) + 1;
            int randomY = randomNumbers.nextInt(7) + 1;
            obstacle.setX(randomX);
            obstacle.setY(randomY);
            list.add(obstacle);
        }
        System.out.println("Tamaño lista: " + list.size());
        for (int i = 0; i< 5; i++){
            repository.save(list.get(i));
            System.out.println(list.get(i));
        }


    }

    @Override
    public List<Obstacle> findAll() {
        return repository.findAll();
    }
}
