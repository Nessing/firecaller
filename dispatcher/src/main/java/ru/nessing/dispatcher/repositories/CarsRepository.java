package ru.nessing.dispatcher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nessing.dispatcher.entities.Car;
import ru.nessing.dispatcher.entities.Team;

import java.util.List;

public interface CarsRepository extends JpaRepository<Car, Long> {
    List<Car> findCarsByFireStation_Id(Long FireStation_Id);
    List<Car> findCarsByFireStation_IdOrderByTeam(Long FireStation_Id);
    Car findCarById(Long carId);
    Car findCarByNameAndAndNumberCar(String name, String numberCar);
    Car findCarByTeamNameAndAndFireStation_Id(String teamName, Long fireStationId);
    Car findCarByTeamIdAndFireStation_Id(Long teamId, Long fireStationId);
}
