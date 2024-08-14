package ru.nessing.firecaller.dispatcher.services;

import org.springframework.stereotype.Service;
import ru.nessing.firecaller.dispatcher.repositories.FireStationRepository;
import ru.nessing.firecaller.entities.FireStation;

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
