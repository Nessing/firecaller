package ru.nessing.firecaller.dispatcher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nessing.firecaller.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
