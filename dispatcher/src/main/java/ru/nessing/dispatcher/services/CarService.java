package ru.nessing.dispatcher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nessing.dispatcher.repositories.CarsRepository;
import ru.nessing.dispatcher.entities.Car;

import java.util.List;

@Service
public class CarService {
    private final CarsRepository carsRepository;

    @Autowired
    public CarService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    public List<Car> getCars(Long fireStation) {
        return carsRepository.findCarsByFireStation_IdOrderByTeam(fireStation);
    }

    public Boolean createCar(Car car) {
        if (carsRepository.findCarByNameAndAndNumberCar(car.getName(), car.getNumberCar()) == null) {
            carsRepository.save(car);
            return true;
        } else {
            return false;
        }
    }

    public Boolean updateCar(Car car) {
        if (car.getTeam() != null) {
            String teamName = car.getTeam().getName();
            Car currentCar = carsRepository.findCarById(car.getId());
            Car foundCar = carsRepository.findCarByTeamNameAndAndFireStation_Id(teamName, car.getFireStation().getId());
            if (foundCar != null) {
                foundCar.setTeam(currentCar.getTeam());
                carsRepository.save(foundCar);
            }
            carsRepository.save(car);
            return true;
        } else {
            carsRepository.save(car);
            return true;
        }
    }

    public void deleteCar(Car car) {
        carsRepository.deleteById(car.getId());
    }
}
