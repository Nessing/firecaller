package ru.nessing.dispatcher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nessing.dispatcher.services.RankService;
import ru.nessing.dispatcher.entities.Rank;

import java.util.List;

@RestController
public class RankController {
    private final RankService service;

    @Autowired
    public RankController(RankService service) {
        this.service = service;
    }

    @GetMapping("/getAllRanks")
    public List<Rank> getAllRanks() {
        return service.getAllRanks();
    }

    @PostMapping("/removeRank")
    public Boolean deletePosition(@RequestBody Rank rank) {
        return service.deleteRank(rank);
    }

    @PostMapping("/createRank")
    public Boolean addPosition(@RequestBody Rank rank) {
        return service.addRank(rank.getName());
    }
}
