package ru.nessing.dispatcher.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nessing.dispatcher.entities.Rank;

public interface RankRepository extends JpaRepository<Rank, Long> {
    Rank findRankByName(String rank);
}
