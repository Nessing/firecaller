package ru.nessing.firecaller.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Firefighter {
    private Long id;
    private String name;
    private String rank;
    private int fireStation;
}
