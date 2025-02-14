package ru.nessing.dispatcher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nessing.dispatcher.entities.TeamOfFireStation;

import java.util.List;

@Repository
public interface TeamOfFireStationRepository extends JpaRepository<TeamOfFireStation, Long> {
    TeamOfFireStation findTeamOfFireStationByFireStation_IdAndAndTeam_Id(Long FireStationId, Long TeamId);
    List<TeamOfFireStation> findByFireStation_Id(Long FireStationId);
}
