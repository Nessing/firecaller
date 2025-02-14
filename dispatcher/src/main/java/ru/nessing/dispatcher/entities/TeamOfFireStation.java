package ru.nessing.dispatcher.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "teams_of_fire_stations")
public class TeamOfFireStation implements Comparable<TeamOfFireStation> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fire_station_id", referencedColumnName = "id")
    private FireStation fireStation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    @ManyToOne(optional = false)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column(name = "location")
    private String location;

    @Override
    public int compareTo(TeamOfFireStation otherTeam) {
        return this.getTeam().getName().compareTo(otherTeam.getTeam().getName());
    }
}
