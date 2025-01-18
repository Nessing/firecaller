package ru.nessing.dispatcher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.nessing.dispatcher.services.CarService;
import ru.nessing.dispatcher.entities.Car;
import ru.nessing.dispatcher.utils.PermissionUser;

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

    @GetMapping("/getCars")
    public List<Car> getCars() {
        PermissionUser permission = new PermissionUser();
        if (permission.getNumberOfFireStation() != null) {
            return service.getCars(Long.parseLong(permission.getNumberOfFireStation()));
        }
        return null;
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
