package ru.nessing.firecaller.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Square {
    private Long id;
    private Integer command;
    private String name;
    private String status;
    private String location;
}
