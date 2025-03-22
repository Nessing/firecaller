package ru.nessing.dispatcher.entities.DTOs;

import lombok.Builder;
import lombok.Data;
import ru.nessing.dispatcher.entities.FireStation;
import ru.nessing.dispatcher.entities.Position;

@Data
@Builder
public class FirefighterDto {
    private Long id;
    private String firstName;
    private String midName;
    private String lastName;
    private Long positionId;
    private Long rankId;
    private Long teamId;
    private Long fireStationId;
}
