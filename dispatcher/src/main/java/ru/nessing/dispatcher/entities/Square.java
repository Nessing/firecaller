package ru.nessing.dispatcher.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Square {

    private Team team;
    private FireStation fireStation;
    private Car car;
    private List<Firefighter> firefighters = new ArrayList<>();
    private String location;
}
