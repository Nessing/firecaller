package ru.nessing.dispatcher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nessing.dispatcher.entities.FireStation;

@Repository
public interface FireStationRepository extends JpaRepository<FireStation, Long> {
    FireStation findFireStationById(Long id);
}
