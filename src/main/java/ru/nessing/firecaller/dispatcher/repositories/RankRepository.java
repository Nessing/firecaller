package ru.nessing.firecaller.dispatcher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nessing.firecaller.entities.Rank;

public interface RankRepository extends JpaRepository<Rank, Long> {
    Rank findRankByName(String rank);
}
