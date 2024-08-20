package ru.nessing.dispatcher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nessing.dispatcher.services.CarService;
import ru.nessing.dispatcher.entities.Car;

import java.util.List;

@RestController
public class CarController {
    private final CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping("/getCars/{fireStation}")
    public List<Car> getCars(@PathVariable Long fireStation) {
        return service.getCars(fireStation);
    }

    @PostMapping("/updateCar")
    public Boolean updateCar(@RequestBody Car car) {
        return service.updateCar(car);
    }

    @PostMapping("/deleteCar")
    public void deleteCar(@RequestBody Car car) {
        service.deleteCar(car);
    }
    @PostMapping("/createCar")
    public Boolean createCar(@RequestBody Car car) {
        return service.createCar(car);
    }
}
