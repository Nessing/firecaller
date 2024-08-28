package ru.nessing.dispatcher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nessing.dispatcher.entities.DTOs.StatusDto;
import ru.nessing.dispatcher.entities.Status;
import ru.nessing.dispatcher.services.StatusService;

import java.util.List;

@RestController
public class StatusController {

    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/getAllStatus")
    public List<Status> getAllStatus() {
        return statusService.getAllStatus();
    }

    @PostMapping("/updateStatus")
    public void updateStatus(@RequestBody StatusDto statusDto) {
        statusService.updateStatus(statusDto);
    }
}
