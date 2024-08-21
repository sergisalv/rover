package com.example.rover.repository;

import com.example.rover.models.Rover;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoverRepository extends JpaRepository <Rover, Long> {

}
