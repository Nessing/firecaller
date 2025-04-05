package ru.nessing.dispatcher.utils;

import lombok.Data;
import ru.nessing.dispatcher.entities.Status;
import ru.nessing.dispatcher.entities.TeamOfFireStation;

import java.util.List;

@Data
public class TeamInfo {

    private Status status;
    private String location;

    public TeamInfo(List<TeamOfFireStation> teams, Long fireStationId, Long teamId) {
        for (TeamOfFireStation team : teams) {
            if (team.getFireStation().getId().equals(fireStationId) && team.getTeam().getId().equals(teamId)) {
                status = team.getStatus();
                location = team.getLocation();
                break;
            }
        }
    }
}
