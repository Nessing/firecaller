package ru.nessing.dispatcher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<FireStationInfo> getFireStationsAndSquares() {
        return service.getFireStationsAndSquares();
    }

    @GetMapping("/getSquareOfStation/{id}")
    public List<Square> getSquareOfStation(@PathVariable Long id) {
        return service.getSquareOfStation(id);
    }

    @GetMapping("/getTeams")
    public List<Team> getSquare() {
        return service.getTeams();
    }
}
