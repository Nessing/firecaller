package ru.nessing.dispatcher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nessing.dispatcher.entities.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findTeamByName(String name);
}
