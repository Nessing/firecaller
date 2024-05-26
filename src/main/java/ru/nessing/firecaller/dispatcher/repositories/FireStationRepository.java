package ru.nessing.firecaller.dispatcher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nessing.firecaller.entities.FireStation;

@Repository
public interface FireStationRepository extends JpaRepository<FireStation, Long> {
    FireStation findFireStationById(Long id);
}
