package com.example.rover.dto;

import com.example.rover.models.Direction;
import lombok.Data;

@Data
public class RoverDto {
        private Integer x;
        private Integer y;
        private Direction direction;


}
