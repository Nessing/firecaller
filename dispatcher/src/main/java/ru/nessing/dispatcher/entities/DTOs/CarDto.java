package ru.nessing.dispatcher.entities.DTOs;

import lombok.Data;

@Data
public class CarDto {
    private Long id;
    private Long fireStationId;
    private String name;
    private String numberCar;
    private Long teamId;
}
