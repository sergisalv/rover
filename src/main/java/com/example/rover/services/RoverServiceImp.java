package com.example.rover.services;

import com.example.rover.models.Direction;
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

    @Override
    public void sendCommand(String command) {
        Rover rover = get();

        switch (command){
            case "F":
                if (Direction.NORTH.equals(rover.getDirection())){
                    rover.setY(rover.getY() - 1);
                    break;
                } else if (Direction.EAST.equals(rover.getDirection())){
                    rover.setX(rover.getX() + 1);
                    break;
                }else if (Direction.SOUTH.equals(rover.getDirection())){
                    rover.setY(rover.getY() + 1);
                    break;
                } else if (Direction.WEST.equals(rover.getDirection())) {
                    rover.setX(rover.getX() - 1);
                    break;
                }
            case "B":
                if (Direction.NORTH.equals(rover.getDirection())){
                    rover.setY(rover.getY() + 1);
                    break;
                } else if (Direction.EAST.equals(rover.getDirection())){
                    rover.setX(rover.getX() - 1);
                    break;
                }else if (Direction.SOUTH.equals(rover.getDirection())){
                    rover.setY(rover.getY() - 1);
                    break;
                } else if (Direction.WEST.equals(rover.getDirection())) {
                    rover.setX(rover.getX() + 1);
                    break;
                }
            case "R":
                if (Direction.NORTH.equals(rover.getDirection())){
                    rover.setDirection(Direction.EAST);
                    break;
                } else if (Direction.EAST.equals(rover.getDirection())){
                    rover.setDirection(Direction.SOUTH);
                    break;
                }else if (Direction.SOUTH.equals(rover.getDirection())){
                    rover.setDirection(Direction.WEST);
                    break;
                }else if (Direction.WEST.equals(rover.getDirection())){
                    rover.setDirection(Direction.NORTH);
                    break;
                }
            case "L":
                if (Direction.NORTH.equals(rover.getDirection())){
                    rover.setDirection(Direction.WEST);
                    break;
                } else if (Direction.WEST.equals(rover.getDirection())){
                    rover.setDirection(Direction.SOUTH);
                    break;
                }else if (Direction.SOUTH.equals(rover.getDirection())){
                    rover.setDirection(Direction.EAST);
                    break;
                }else if (Direction.EAST.equals(rover.getDirection())){
                    rover.setDirection(Direction.NORTH);
                    break;
                }

        }

        repository.save(rover);
    }
}
