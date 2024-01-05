package ru.nessing.firecaller.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class FireStation {
    private Long id;
    private int numberStation;
    private String name;
    private String title;
    private String state;
    private String location;
    private List<Firefighter> firefighters;
}
