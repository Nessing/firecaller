package ru.nessing.dispatcher.entities;

public enum StatusOfTeam {
    CALM("в части"),
    ON_THE_WAY("в пути"),
    ON_THE_DESTINATION("на месте вызова");

    private final String state;

    StatusOfTeam(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
