package ru.nessing.firecaller.dispatcher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nessing.firecaller.entities.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    Position findPositionByName(String position);
}
