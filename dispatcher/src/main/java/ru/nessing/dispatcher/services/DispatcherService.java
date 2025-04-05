package ru.nessing.dispatcher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.nessing.dispatcher.configurations.CustomUserDetails;
import ru.nessing.dispatcher.repositories.*;
import ru.nessing.dispatcher.entities.*;
import ru.nessing.dispatcher.utils.FireStationInfo;
import ru.nessing.dispatcher.utils.Square;
import ru.nessing.dispatcher.webSockets.WebSocketNotificationService;

import java.util.*;

@Service
public class DispatcherService {

    private final PersonRepository personRepository;
    private final FireStationRepository fireStationRepository;
    private final CarsRepository carsRepository;
    private final TeamRepository teamRepository;
    private final TeamOfFireStationRepository teamOfFireStationRepository;
    private final WebSocketNotificationService webSocketNotificationService;

    public String getPermissionForAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUserDetails details) {
            return details.getPermission().getName();
        }
        return null;
    }

    @Autowired
    public DispatcherService(PersonRepository personRepository,
                             FireStationRepository fireStationRepository,
                             CarsRepository carsRepository,
                             TeamRepository teamRepository,
                             TeamOfFireStationRepository teamOfFireStationRepository,
                             WebSocketNotificationService webSocketNotificationService)
    {
        this.personRepository = personRepository;
        this.fireStationRepository = fireStationRepository;
        this.carsRepository = carsRepository;
        this.teamRepository = teamRepository;
        this.teamOfFireStationRepository = teamOfFireStationRepository;
        this.webSocketNotificationService = webSocketNotificationService;
    }

    public List<FireStationInfo> getFireStationsAndSquares() {
        List<FireStation> fireStations = fireStationRepository.findAll();
        List<Car> cars = carsRepository.findAll();

        List<FireStationInfo> fireStationInfos = new ArrayList<>();
        fireStations.forEach(station -> {
                List<Square> squares = new ArrayList<>();
                cars.stream()
                    .filter(car -> car.getFireStation().equals(station) && car.getTeam() != null)
                    .forEach(car -> {
                        Square square = new Square();
                        square.setFireStation(station);
                        square.setCar(car);
                        square.setTeam(car.getTeam());
                        squares.add(square);
                    });
                Collections.sort(squares);
                fireStationInfos.add(new FireStationInfo(station, squares));
            }
        );
        return fireStationInfos;
    }

    public List<Square> getSquareOfStation(Long stationId) {
        List<Square> squares = new ArrayList<>();
//        FireStation fireStation = fireStationRepository.findFireStationById(stationId);
//        List<Firefighter> firefighters = personRepository.findFirefightersByFireStation_IdOrderByTeam(stationId);
//        List<Car> cars = carsRepository.findCarsByFireStation_IdOrderByTeam(stationId);
        List<TeamOfFireStation> teams = teamOfFireStationRepository.findByFireStation_Id(stationId);
        Collections.sort(teams);

        for (TeamOfFireStation team : teams) {
            Long teamId = team.getTeam().getId();
            Long fireStationId = team.getFireStation().getId();
            Square square = new Square();
            square.setFireStation(team.getFireStation());
            square.setTeam(team.getTeam());
            square.setStatus(team.getStatus());
            square.setLocation(team.getLocation());
            square.setFirefighters(personRepository.findFirefightersByTeamIdAndFireStationId(teamId, fireStationId));
            square.setCar(carsRepository.findCarByTeamIdAndFireStation_Id(teamId, fireStationId));
            squares.add(square);
        }

//        for (Car car : cars) {
//            if (car.getTeam() != null) {
//                Square square = new Square();
//                square.setFireStation(fireStation);
//                square.setCar(car);
//                square.setTeam(car.getTeam());
//                Status status = FindStatusOfTeam.findStatus(teams, stationId, square.getTeam().getId());
//                square.setStatus(status);
//                for (Firefighter firefighter : firefighters) {
//                    if (firefighter.getTeam() != null && firefighter.getTeam().equals(square.getTeam())) {
//                        square.getFirefighters().add(firefighter);
//                    }
//                }
//                squares.add(square);
//            }
//        }
        return squares;
    }

    public List<Team> getTeams() {
        getPermissionForAuthenticatedUser();
        return teamRepository.findAll();
    }

    public TeamOfFireStation updateLocationTeam(Long stationId, Long teamId, String location) {
        TeamOfFireStation team = teamOfFireStationRepository.findTeamOfFireStationByFireStation_IdAndAndTeam_Id(stationId, teamId);
        team.setLocation(location);
        teamOfFireStationRepository.save(team);
        webSocketNotificationService.notifyClients("updateLocationTeam");
        return team;
    }
}
