package ru.nessing.dispatcher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nessing.dispatcher.repositories.*;
import ru.nessing.dispatcher.entities.*;
import ru.nessing.dispatcher.utils.FireStationInfo;
import ru.nessing.dispatcher.utils.Square;

import java.util.*;

@Service
public class DispatcherService {

    private final PersonRepository personRepository;
    private final FireStationRepository fireStationRepository;
    private final CarsRepository carsRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public DispatcherService(PersonRepository personRepository,
                             FireStationRepository fireStationRepository,
                             CarsRepository carsRepository,
                             TeamRepository teamRepository)
    {
        this.personRepository = personRepository;
        this.fireStationRepository = fireStationRepository;
        this.carsRepository = carsRepository;
        this.teamRepository = teamRepository;
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

//       for (FireStation station : fireStations) {
//           cars.stream()
//                   .filter(car -> car.getFireStation().equals(station) && car.getTeam() != null)
//                   .forEach(car -> {
//                       Square square = new Square();
//                       square.setFireStation(station);
//                       square.setCar(car);
//                       square.setTeam(car.getTeam());
//                       squares.add(square);
//                   });
//       }
        return fireStationInfos;
    }

    public List<Square> getSquareOfStation(Long stationId) {
        List<Square> squares = new ArrayList<>();
        FireStation fireStation = fireStationRepository.findFireStationById(stationId);
        List<Firefighter> firefighters = personRepository.findFirefightersByFireStation_IdOrderByTeam(stationId);
        List<Car> cars = carsRepository.findCarsByFireStation_IdOrderByTeam(stationId);

        for (Car car : cars) {
            if (car.getTeam() != null) {
                Square square = new Square();
                square.setFireStation(fireStation);
                square.setCar(car);
                square.setTeam(car.getTeam());
                for (Firefighter firefighter : firefighters) {
                    if (firefighter.getTeam() != null && firefighter.getTeam().equals(square.getTeam())) {
                        square.getFirefighters().add(firefighter);
                    }
                }
                squares.add(square);
            }
        }
        return squares;
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }
}