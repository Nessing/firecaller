package ru.nessing.dispatcher.entities.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.nessing.dispatcher.entities.Status;

@Data
@Builder
@AllArgsConstructor
public class StatusDto {
    private Long fireStationId;
    private Long teamId;
    private Long statusId;
}
