package ru.nessing.dispatcher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nessing.dispatcher.entities.DTOs.StatusDto;
import ru.nessing.dispatcher.entities.Status;
import ru.nessing.dispatcher.entities.TeamOfFireStation;
import ru.nessing.dispatcher.repositories.StatusRepository;
import ru.nessing.dispatcher.repositories.TeamOfFireStationRepository;

import java.util.List;

@Service
public class StatusService {
    private final StatusRepository statusRepository;
    private final TeamOfFireStationRepository teamOfFireStationRepository;

    public StatusService(StatusRepository statusRepository,
                         TeamOfFireStationRepository teamOfFireStationRepository) {
        this.statusRepository = statusRepository;
        this.teamOfFireStationRepository = teamOfFireStationRepository;
    }

    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    public void updateStatus(StatusDto statusDto) {
        TeamOfFireStation team = teamOfFireStationRepository
                .findTeamOfFireStationByFireStation_IdAndAndTeam_Id(statusDto.getFireStationId(), statusDto.getTeamId());
        if (team != null) {
            team.setStatus(statusDto.getStatus());
            teamOfFireStationRepository.save(team);
        }
    }
}
