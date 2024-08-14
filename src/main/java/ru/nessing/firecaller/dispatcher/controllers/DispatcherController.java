package ru.nessing.firecaller.dispatcher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nessing.firecaller.dispatcher.services.DispatcherService;
import ru.nessing.firecaller.entities.*;

import java.util.List;

@RestController
public class DispatcherController {

    @Autowired
    private DispatcherService service;

    @GetMapping("/getSquareOfStation/{id}")
    public List<Square> getSquareOfStation(@PathVariable Long id) {
        return service.getSquareOfStation(id);
    }

    @GetMapping("/getTeams")
    public List<Team> getSquare() {
        return service.getTeams();
    }
}
