package ru.nessing.firecaller.dispatcher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nessing.firecaller.entities.Car;

import java.util.List;

public interface CarsRepository extends JpaRepository<Car, Long> {
    List<Car> findCarsByFireStation_Id(Long id);
    Car findCarByNameAndAndNumberCar(String name, String numberCar);
}
