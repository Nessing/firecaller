package ru.nessing.dispatcher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nessing.dispatcher.entities.DTOs.CarDto;
import ru.nessing.dispatcher.entities.Team;
import ru.nessing.dispatcher.repositories.CarsRepository;
import ru.nessing.dispatcher.entities.Car;
import ru.nessing.dispatcher.repositories.FireStationRepository;
import ru.nessing.dispatcher.repositories.TeamRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarsRepository carsRepository;
    private final TeamRepository teamRepository;
    private final FireStationRepository fireStationRepository;

    @Autowired
    public CarService(CarsRepository carsRepository, TeamRepository teamRepository, FireStationRepository fireStationRepository) {
        this.carsRepository = carsRepository;
        this.teamRepository = teamRepository;
        this.fireStationRepository = fireStationRepository;
    }

    public List<Car> getCars(Long fireStation) {
        return carsRepository.findCarsByFireStation_IdOrderByTeam(fireStation);
    }

    public Boolean createCar(CarDto carDto) {
        carDto.setId(null);
        Car car = new Car();
        car.setName(carDto.getName());
        car.setNumberCar(carDto.getNumberCar());
        car.setFireStation(fireStationRepository.findFireStationById(carDto.getFireStationId()));
        if (car.getName() == null || car.getName().trim().isEmpty() ||
                car.getNumberCar() == null || car.getNumberCar().trim().isEmpty()) {
            return false;
        }
        if (carsRepository.findCarByNameAndAndNumberCar(car.getName(), car.getNumberCar()) == null) {
            if (carDto.getTeamId() != null) {
                Team team = teamRepository.findById(carDto.getTeamId()).orElse(null);
                if (team != null) {
                    Car findCar = carsRepository.findCarByTeamIdAndFireStation_Id(team.getId(), carDto.getFireStationId());
                    findCar.setTeam(null);
                    carsRepository.save(findCar);
                }
                car.setTeam(team);
            }
            carsRepository.save(car);
            return true;
        } else {
            return false;
        }
    }

    public Boolean updateCar(CarDto carDto) {
        if (carDto == null || carDto.getId() == null) return false;

        Car newCar = carsRepository.findCarById(carDto.getId());
        if (newCar == null) return false;

        newCar.setName(carDto.getName());
        newCar.setNumberCar(carDto.getNumberCar());
        Team team = teamRepository.findById(carDto.getTeamId()).orElse(null);
        if (team != null) {
            Car findCar = carsRepository.findCarByTeamIdAndFireStation_Id(team.getId(), newCar.getFireStation().getId());
            findCar.setTeam(newCar.getTeam());
        }
        newCar.setTeam(team);
        carsRepository.save(newCar);
        return true;
    }

    public void deleteCar(Long carId) {
        carsRepository.deleteById(carId);
    }
}
