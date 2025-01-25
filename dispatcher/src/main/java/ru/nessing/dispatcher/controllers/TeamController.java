package ru.nessing.dispatcher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.nessing.dispatcher.entities.TeamOfFireStation;
import ru.nessing.dispatcher.services.DispatcherService;
import ru.nessing.dispatcher.services.TeamService;
import ru.nessing.dispatcher.utils.FireStationInfo;
import ru.nessing.dispatcher.utils.PermissionUser;
import ru.nessing.dispatcher.utils.Square;

import java.util.List;

@RestController
public class TeamController {
    private final TeamService teamService;
    private final DispatcherService dispatcherService;

    @Autowired
    public TeamController(TeamService teamService, DispatcherService dispatcherService) {
        this.teamService = teamService;
        this.dispatcherService = dispatcherService;
    }

    @GetMapping("/getAllTeamOfFireStation")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<FireStationInfo> getAllTeamOfFireStation() {
        return teamService.getAllTeamOfFireStation();
    }

    @GetMapping("/getSquareOfStation/{id}")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Square> getSquareOfStation(@PathVariable Long id) {
        return dispatcherService.getSquareOfStation(id);
    }

    @GetMapping("/getSquareOfStation")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Square> getSquareOfStation() {
        PermissionUser permission = new PermissionUser();
        if (permission.getNumberOfFireStation() != null) {
            return dispatcherService.getSquareOfStation(Long.parseLong(permission.getNumberOfFireStation()));
        }
        return null;
    }
}
