package ru.nessing.dispatcher.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.nessing.dispatcher.entities.FireStation;

import java.util.List;

@Data
@AllArgsConstructor
public class FireStationInfo {
    private FireStation fireStation;
    private List<Square> squares;
}
