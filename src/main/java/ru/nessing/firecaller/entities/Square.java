package ru.nessing.firecaller.entities;

import jakarta.persistence.*;
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
//@Entity
//@Table(name = "firefighters")
public class Square {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;

    private Team team;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "fire_station_id", referencedColumnName = "id")
    private FireStation fireStation;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    private List<Firefighter> firefighters = new ArrayList<>();

    private String status;

    private String location;
}
