package ru.nessing.dispatcher.utils;

import lombok.Data;
import ru.nessing.dispatcher.entities.FireStation;
import ru.nessing.dispatcher.entities.Position;

@Data
public class FirefighterUtils {
    private String firstName;
    private String midName;
    private String lastName;
    private String shortName;
    private String rank;
    private Position position;
    private FireStation fireStation;

    public void createShortName(String firstName, String midName, String surName) {
        StringBuilder shortName = new StringBuilder();
        shortName.append(firstName.charAt(0)).append(". ");
        if (midName != null && !midName.trim().isEmpty()) {
            shortName.append(midName.charAt(0)).append(". ");
        }
        this.shortName = shortName.append(surName).toString();
    }
}
