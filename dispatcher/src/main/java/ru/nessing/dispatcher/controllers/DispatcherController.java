package ru.nessing.dispatcher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.nessing.dispatcher.services.DispatcherService;
import ru.nessing.dispatcher.entities.*;
import ru.nessing.dispatcher.utils.FireStationInfo;
import ru.nessing.dispatcher.utils.Square;

import java.util.List;

@RestController
public class DispatcherController {

    @Autowired
    private DispatcherService service;

    @GetMapping("/getFireStationsAndSquares")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<FireStationInfo> getFireStationsAndSquares() {
        return service.getFireStationsAndSquares();
    }

    @GetMapping("/getSquareOfStation/{id}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Square> getSquareOfStation(@PathVariable Long id) {
        return service.getSquareOfStation(id);
    }

    @GetMapping("/getTeams")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN') || hasAuthority('ROLE_USER')")
    public List<Team> getSquare() {
        return service.getTeams();
    }
}
