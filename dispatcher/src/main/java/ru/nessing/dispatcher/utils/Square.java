package ru.nessing.dispatcher.utils;

import lombok.*;
import ru.nessing.dispatcher.entities.Car;
import ru.nessing.dispatcher.entities.FireStation;
import ru.nessing.dispatcher.entities.Firefighter;
import ru.nessing.dispatcher.entities.Team;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Square implements Comparable<Square> {

    private Team team;
    private FireStation fireStation;
    private Car car;
    private List<Firefighter> firefighters = new ArrayList<>();
    private String location;

    @Override
    public int compareTo(@NonNull Square otherSquare) {
        if (this.team == null && otherSquare.team == null) {
            return 0;
        } else if (this.team == null) {
            return -1;
        } else if (otherSquare.team == null) {
            return 1;
        } else {
            return this.team.compareTo(otherSquare.team);
        }
    }
}
