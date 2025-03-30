package ru.nessing.dispatcher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.nessing.dispatcher.entities.DTOs.CarDto;
import ru.nessing.dispatcher.services.CarService;
import ru.nessing.dispatcher.entities.Car;
import ru.nessing.dispatcher.utils.PermissionUser;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/getCars")
    public List<Car> getCars() {
        PermissionUser permission = new PermissionUser();
        if (permission.getNumberOfFireStation() != null) {
            return service.getCars(Long.parseLong(permission.getNumberOfFireStation()));
        }
        return null;
    }

    @PostMapping("/updateCar")
    public Boolean updateCar(@RequestBody CarDto carDto) {
        return service.updateCar(carDto);
    }

    @PostMapping("/deleteCar")
    public void deleteCar(@RequestBody Map<String, Long> request) {
        Long carId = request.get("carId");
        service.deleteCar(carId);
    }
    @PostMapping("/createCar")
    public Boolean createCar(@RequestBody CarDto car) {
        return service.createCar(car);
    }
}
