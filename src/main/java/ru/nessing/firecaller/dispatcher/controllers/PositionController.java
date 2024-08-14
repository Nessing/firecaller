package ru.nessing.firecaller.dispatcher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nessing.firecaller.dispatcher.services.PositionService;
import ru.nessing.firecaller.entities.Position;

import java.util.List;

@RestController
public class PositionController {
    private final PositionService service;

    @Autowired
    public PositionController(PositionService service) {
        this.service = service;
    }

    @GetMapping("/getAllPositions")
    public List<Position> getAllPositions() {
        return service.getAllPositions();
    }

    @PostMapping("/createPosition")
    public Boolean addPosition(@RequestBody Position position) {
        return service.addPosition(position.getName());
    }

    @PostMapping("/removePosition")
    public Boolean deletePosition(@RequestBody Position position) {
        return service.deletePosition(position);
    }
}
