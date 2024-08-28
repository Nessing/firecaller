package ru.nessing.dispatcher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nessing.dispatcher.entities.TeamOfFireStation;
import ru.nessing.dispatcher.services.TeamService;
import ru.nessing.dispatcher.utils.FireStationInfo;

import java.util.List;

@RestController
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/getAllTeamOfFireStation")
    public List<FireStationInfo> getAllTeamOfFireStation() {
        return teamService.getAllTeamOfFireStation();
    }
}
