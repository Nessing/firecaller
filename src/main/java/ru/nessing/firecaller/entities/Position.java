package ru.nessing.firecaller.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Position {
    private Long id;
    private String name;
}
