package ru.nessing.firecaller.dispatcher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nessing.firecaller.dispatcher.repositories.PositionRepository;
import ru.nessing.firecaller.entities.Position;

import java.util.List;

@Service
public class PositionService {
    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Boolean addPosition(String position) {
        if (positionRepository.findPositionByName(position) == null) {
            Position newPosition = Position.builder()
                    .id(null)
                    .name(position)
                    .build();
            positionRepository.save(newPosition);
            return true;
        }
        return false;
    }

    public Boolean deletePosition(Position position) {
        Position pos = positionRepository.findPositionByName(position.getName());
        if (pos != null) {
            positionRepository.delete(pos);
            return true;
        }
        return false;
    }

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }


}
