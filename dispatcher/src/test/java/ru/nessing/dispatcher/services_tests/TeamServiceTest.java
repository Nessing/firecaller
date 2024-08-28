package ru.nessing.dispatcher.services_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nessing.dispatcher.entities.Status;
import ru.nessing.dispatcher.entities.TeamOfFireStation;
import ru.nessing.dispatcher.repositories.TeamOfFireStationRepository;
import ru.nessing.dispatcher.services.TeamService;
import ru.nessing.dispatcher.utils.FindStatusOfTeam;
import ru.nessing.dispatcher.utils.FireStationInfo;

import java.util.List;

@SpringBootTest
public class TeamServiceTest {

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamOfFireStationRepository teamOfFireStationRepository;

    @Test
    public void testGetAllTeamOfFireStation() {
        List<FireStationInfo> teams = teamService.getAllTeamOfFireStation();
        teams.forEach(team -> {
            System.out.println(team.getFireStation().getShortName());
            team.getSquares().forEach(square -> {
                System.out.println(square.getTeam().getName());
                System.out.println(square.getStatus());
            });
        });
    }

    @Test
    public void testFindStatusOfTeam() {
        List<TeamOfFireStation> teams = teamOfFireStationRepository.findAll();
        teams.forEach(System.out::println);
        System.out.println("====");
        Status status = FindStatusOfTeam.findStatus(teams, 1L, 2L);
        System.out.println(status);
        Status statusCheck = Status.builder()
                .id(2L)
                .name("on_the_way")
                .title("в пути")
                .build();
        Assertions.assertEquals(status, statusCheck);
    }
}
