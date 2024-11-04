package ru.nessing.dispatcher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.nessing.dispatcher.services.FireStationService;
import ru.nessing.dispatcher.entities.FireStation;

import java.util.List;
import java.util.Optional;

@RestController
public class FireStationController {
    private final FireStationService service;

    @Autowired
    public FireStationController(FireStationService service) {
        this.service = service;
    }

    @GetMapping("/getFireStations")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<FireStation> getAllFireStations() {
        return service.getAllFireStations();
    }

    @GetMapping("/getFireStation/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') || hasAuthority('ROLE_FIRESTATION')")
    public Optional<FireStation> getFireStation(@PathVariable Long id) {
        return service.getFireStation(id);
    }
}
