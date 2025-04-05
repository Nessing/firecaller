package ru.nessing.dispatcher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nessing.dispatcher.entities.DTOs.StatusDto;
import ru.nessing.dispatcher.entities.Status;
import ru.nessing.dispatcher.entities.TeamOfFireStation;
import ru.nessing.dispatcher.repositories.StatusRepository;
import ru.nessing.dispatcher.repositories.TeamOfFireStationRepository;
import ru.nessing.dispatcher.webSockets.WebSocketNotificationService;

import java.util.List;

@Service
public class StatusService {
    private final StatusRepository statusRepository;
    private final TeamOfFireStationRepository teamOfFireStationRepository;
    private final WebSocketNotificationService webSocketNotificationService;

    public StatusService(StatusRepository statusRepository,
                         TeamOfFireStationRepository teamOfFireStationRepository,
                         WebSocketNotificationService webSocketNotificationService) {
        this.statusRepository = statusRepository;
        this.teamOfFireStationRepository = teamOfFireStationRepository;
        this.webSocketNotificationService = webSocketNotificationService;
    }

    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    public boolean updateStatus(StatusDto statusDto) {
        if (statusDto.getTeamId() != null && statusDto.getFireStationId() != null && statusDto.getStatusId() != null) {
            TeamOfFireStation team = teamOfFireStationRepository
                    .findTeamOfFireStationByFireStation_IdAndAndTeam_Id(statusDto.getFireStationId(), statusDto.getTeamId());
            if (team != null) {
                Status status = statusRepository.findById(statusDto.getStatusId()).orElse(null);
                if (status != null) {
                    team.setStatus(status);
                    teamOfFireStationRepository.save(team);
                    webSocketNotificationService.notifyClients("updateStatus");
                    System.out.println("[LOG] updateStatus");
                    return true;
                }
            } return false;
        }
        return false;
    }
}
