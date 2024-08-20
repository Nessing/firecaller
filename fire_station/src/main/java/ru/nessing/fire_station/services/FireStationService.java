package ru.nessing.fire_station.services;

import org.springframework.stereotype.Service;
import ru.nessing.fire_station.repositories.FireStationRepository;
import ru.nessing.fire_station.entities.FireStation;

import java.util.List;
import java.util.Optional;

@Service
public class FireStationService {
    private final FireStationRepository fireStationRepository;

    public FireStationService(FireStationRepository fireStationRepository) {
        this.fireStationRepository = fireStationRepository;
    }

    public List<FireStation> getAllFireStations() {
        return fireStationRepository.findAll();
    }

    public Optional<FireStation> getFireStation(Long stationId) {
        return fireStationRepository.findById(stationId);
    }
}
