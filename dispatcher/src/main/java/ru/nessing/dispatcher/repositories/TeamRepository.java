package ru.nessing.dispatcher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nessing.dispatcher.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findTeamByName(String name);
}
