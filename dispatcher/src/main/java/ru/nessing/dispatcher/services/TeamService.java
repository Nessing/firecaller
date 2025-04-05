package ru.nessing.dispatcher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nessing.dispatcher.entities.Car;
import ru.nessing.dispatcher.entities.FireStation;
import ru.nessing.dispatcher.entities.TeamOfFireStation;
import ru.nessing.dispatcher.repositories.CarsRepository;
import ru.nessing.dispatcher.repositories.FireStationRepository;
import ru.nessing.dispatcher.repositories.TeamOfFireStationRepository;
import ru.nessing.dispatcher.utils.TeamInfo;
import ru.nessing.dispatcher.utils.FireStationInfo;
import ru.nessing.dispatcher.utils.Square;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TeamService {
    private final TeamOfFireStationRepository teamOfFireStationRepository;
    private final FireStationRepository fireStationRepository;
    private final CarsRepository carsRepository;

    @Autowired
    public TeamService(TeamOfFireStationRepository teamOfFireStationRepository,
                       FireStationRepository fireStationRepository,
                       CarsRepository carsRepository) {
        this.teamOfFireStationRepository = teamOfFireStationRepository;
        this.fireStationRepository = fireStationRepository;
        this.carsRepository = carsRepository;
    }


    public List<FireStationInfo> getAllTeamOfFireStation() {
        List<FireStation> fireStations = fireStationRepository.findAll();
        List<Car> cars = carsRepository.findAll();
        List<TeamOfFireStation> teams = teamOfFireStationRepository.findAll();

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
                                TeamInfo teamInfo = new TeamInfo(teams, station.getId(), square.getTeam().getId());
                                square.setStatus(teamInfo.getStatus());
                                square.setLocation(teamInfo.getLocation());
                                squares.add(square);
                            });
                    Collections.sort(squares);
                    fireStationInfos.add(new FireStationInfo(station, squares));
                }
        );
        return fireStationInfos;
    }
}
