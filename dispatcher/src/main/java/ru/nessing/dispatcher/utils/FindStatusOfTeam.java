package ru.nessing.dispatcher.utils;

import ru.nessing.dispatcher.entities.Status;
import ru.nessing.dispatcher.entities.TeamOfFireStation;

import java.util.List;

public class FindStatusOfTeam {

    public static Status findStatus(List<TeamOfFireStation> teams, Long fireStationId, Long teamId) {
        if (fireStationId == null || teamId == null) return null;
        for (TeamOfFireStation team : teams) {
            if (team.getFireStation().getId().equals(fireStationId) && team.getTeam().getId().equals(teamId)) {
                return team.getStatus();
            }
        }
        return null;
    }
}
