package ru.nessing.firecaller.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fire_stations")
public class FireStation {
    /*
    CREATE TABLE fire_stations (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    number_station INT NOT NULL,
    name VARCHAR(250) NOT NULL,
    short_name VARCHAR(100) NOT NULL,
    location VARCHAR(150) NOT NULL
    );*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "number_station")
    private int numberStation;

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String short_name;

    @Column(name = "location")
    private String location;
}
