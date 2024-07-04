package ru.nessing.firecaller.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "firefighters")
public class Square {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fire_station_id", referencedColumnName = "id")
    private FireStation fireStation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    private String status;

    private String location;
}
