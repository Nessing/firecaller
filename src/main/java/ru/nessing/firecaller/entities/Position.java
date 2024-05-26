package ru.nessing.firecaller.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 CREATE TABLE positions(
 id BIGSERIAL NOT NULL PRIMARY KEY,
 name VARCHAR(150) NOT NULL
 );

 CREATE TABLE firefighters_positions(
 firefighter_id BIGSERIAL REFERENCES firefighters(id),
 position_id BIGSERIAL REFERENCES positions(id),
 UNIQUE (position_id); - Один пожарный может иметь только одну должность
 );
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;
}
