package ru.nessing.firecaller.dispatcher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nessing.firecaller.dispatcher.repositories.*;
import ru.nessing.firecaller.entities.*;
import ru.nessing.firecaller.entities.DTOs.FirefighterDTO;

import java.util.*;

@Service
public class DispatcherService {

    private final PersonRepository personRepository;
    private final PositionRepository positionRepository;
    private final FireStationRepository fireStationRepository;
    private final CarsRepository carsRepository;
    private final TeamRepository teamRepository;
    private final RankRepository rankRepository;

    @Autowired
    public DispatcherService(PersonRepository personRepository,
                             PositionRepository positionRepository,
                             FireStationRepository fireStationRepository,
                             CarsRepository carsRepository,
                             TeamRepository teamRepository,
                             RankRepository rankRepository)
    {
        this.personRepository = personRepository;
        this.positionRepository = positionRepository;
        this.fireStationRepository = fireStationRepository;
        this.carsRepository = carsRepository;
        this.teamRepository = teamRepository;
        this.rankRepository = rankRepository;
    }

    private List<Square> squareStation1 = new ArrayList<>();
    private List<Square> squareStation2 = new ArrayList<>();

    public Firefighter getFire(Long id) {
        return personRepository.findFirefighterById(id);
    }

    public List<Square> getSquare(int fireStation) {
        switch (fireStation) {
            case 1 : return squareStation1;
            case 2 : return squareStation2;
//            case 3 : return firefighters3;
            default: return null;
        }
    }
    /** Добавить метод удаления пожарного
     **/

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
