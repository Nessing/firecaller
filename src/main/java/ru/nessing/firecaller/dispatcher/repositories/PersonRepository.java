package ru.nessing.firecaller.dispatcher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nessing.firecaller.entities.Firefighter;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Firefighter, Long> {
    Firefighter findFirefighterById(Long id);
    List<Firefighter> findFirefightersByFireStation_IdOrderByTeam(Long id);
}
