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
@Entity
@Table(name = "firefighters")
public class Firefighter {
    /**
    CREATE TABLE firefighters (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    rank VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    fire_station INT NOT NULL
    );

    ALTER TABLE firefighters
    ALTER COLUMN fire_station
    TYPE BIGINT;

    ALTER TABLE firefighters
    ADD FOREIGN KEY (fire_station)
    REFERENCES fire_stations(id);

    // связующая таблица firefighters ←→ fire_stations
    CREATE TABLE firefighters_fire_stations(
    firefighter BIGSERIAL REFERENCES firefighters(id),
    fire_station BIGSERIAL REFERENCES fire_stations(id)
    );

    INSERT INTO firefighters_fire_stations(
    firefighter_id, fire_station_id)
    VALUES(4, 1);

     // связь firefighters ←→ positions

     ALTER TABLE firefighters
     ALTER COLUMN position
     TYPE BIGINT;

     ALTER TABLE firefighters
     ADD FOREIGN KEY (position)
     REFERENCES positions(id);
    **/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rank")
    private String rank;

//    @Column(name = "position")
    @ManyToOne
    @JoinTable(name = "firefighters_positions",
            joinColumns = @JoinColumn(name = "firefighter_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id")
    )
    private Position position;

    @ManyToOne
    @JoinTable(name = "firefighters_fire_stations",
            joinColumns = @JoinColumn(name = "Firefighter_id"),
            inverseJoinColumns = @JoinColumn(name = "fire_station_id")
    )
    private FireStation fireStation;
}
