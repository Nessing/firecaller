package ru.nessing.firecaller.dispatcher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nessing.firecaller.dispatcher.repositories.RankRepository;
import ru.nessing.firecaller.entities.Rank;

import java.util.List;

@Service
public class RankService {
    private final RankRepository rankRepository;

    @Autowired
    public RankService(RankRepository rankRepository) {
        this.rankRepository = rankRepository;
    }

    public Boolean addRank(String rank) {
        if (rankRepository.findRankByName(rank) == null) {
            Rank newRank = Rank.builder()
                    .id(null)
                    .name(rank)
                    .build();
            rankRepository.save(newRank);
            return true;
        }
        return false;
    }

    public Boolean deleteRank(Rank rank) {
        Rank pos = rankRepository.findRankByName(rank.getName());
        if (pos != null) {
            rankRepository.delete(pos);
            return true;
        }
        return false;
    }

    public List<Rank> getAllRanks() {
        return rankRepository.findAll();
    }
}
