package ru.nessing.firecaller.entities;

public enum StateFireStation {
    CALM("в части"),
    ON_THE_WAY("в пути"),
    ON_THE_DESTINATION("на месте вызова");

    private final String state;

    StateFireStation(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
