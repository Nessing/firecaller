package ru.nessing.dispatcher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.nessing.dispatcher.entities.TeamOfFireStation;
import ru.nessing.dispatcher.services.DispatcherService;
import ru.nessing.dispatcher.services.TeamService;
import ru.nessing.dispatcher.utils.FireStationInfo;
import ru.nessing.dispatcher.utils.PermissionUser;
import ru.nessing.dispatcher.utils.Square;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/updateLocation")
//    @PostMapping("/updateLocation/{teamId}{stationId}{location}")
//    public TeamOfFireStation updateLocationTeam(@PathVariable Long stationId, @PathVariable Long teamId, @PathVariable String location) {
    public TeamOfFireStation updateLocationTeam(@RequestBody Map<String, String> request) {
        Long fireStationId = Long.valueOf(request.get("fireStationId"));
        Long teamId = Long.valueOf(request.get("teamId"));
        String location = String.valueOf(request.get("location"));
        return dispatcherService.updateLocationTeam(fireStationId, teamId, location);
    }
}
