package ru.nessing.dispatcher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nessing.dispatcher.entities.*;
import ru.nessing.dispatcher.entities.DTOs.FirefighterDto;
import ru.nessing.dispatcher.repositories.*;
import ru.nessing.dispatcher.utils.FirefighterUtils;
import ru.nessing.dispatcher.utils.PermissionUser;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final FireStationRepository fireStationRepository;
    private final TeamRepository teamRepository;
    private final RankRepository rankRepository;
    private final PositionRepository positionRepository;


    @Autowired
    public PersonService(PersonRepository personRepository, FireStationRepository fireStationRepository,
                         TeamRepository teamRepository, RankRepository rankRepository,
                         PositionRepository positionRepository) {
        this.personRepository = personRepository;
        this.fireStationRepository = fireStationRepository;
        this.teamRepository = teamRepository;
        this.rankRepository = rankRepository;
        this.positionRepository = positionRepository;
    }

    public List<Firefighter> getPersons(Long fireStation) {
        return personRepository.findFirefightersByFireStation_IdOrderByTeam(fireStation);
    }

    public Firefighter createFirefighter(FirefighterDto firefighterDto) {
        if (!checkValid(firefighterDto)) return null;

        firefighterDto.setId(null);
        Firefighter firefighter = new Firefighter();
        FirefighterUtils firefighterUtils = new FirefighterUtils();
        firefighterUtils.createShortName(firefighterDto.getFirstName(), firefighterDto.getMidName(), firefighterDto.getLastName());
        firefighter.setShortName(firefighterUtils.getShortName());
        firefighter.setFirstName(firefighterDto.getFirstName());
        firefighter.setMidName(firefighterDto.getMidName());
        firefighter.setLastName(firefighterDto.getLastName());
        firefighter.setFireStation(fireStationRepository.findFireStationById(firefighterDto.getFireStationId()));
        if (firefighterDto.getTeamId() != null) {
            Optional<Team> team = teamRepository.findById(firefighterDto.getTeamId());
            firefighter.setTeam(team.get());
        } else {
            firefighter.setTeam(null);
        }
        Optional<Position> position = positionRepository.findById(firefighterDto.getPositionId());
        Optional<Rank> rank = rankRepository.findById(firefighterDto.getRankId());
        firefighter.setPosition(position.get());
        firefighter.setRank(rank.get());
        personRepository.save(firefighter);
        return firefighter;
    }

    private boolean checkValid(FirefighterDto firefighterDto) {
        if (firefighterDto.getFirstName() == null || firefighterDto.getLastName() == null
                || firefighterDto.getPositionId() == null || firefighterDto.getRankId() == null) {
            return false;
        }
        return true;
    }

//    public Firefighter createFirefighter(Firefighter firefighter) {
//        FirefighterUtils firefighterUtils = new FirefighterUtils();
//        firefighterUtils.createShortName(firefighter.getFirstName(), firefighter.getMidName(), firefighter.getLastName());
//        firefighter.setId(null);
//        firefighter.setShortName(firefighterUtils.getShortName());
//        if (firefighter.getPosition() != null && firefighter.getFireStation() != null) {
//            FireStation fireStation = fireStationRepository.findFireStationById(firefighter.getFireStation().getId());
//            firefighter.setFireStation(fireStation);
//            personRepository.save(firefighter);
//            return firefighter;
//        }
//        return null;
//    }

    public Boolean deleteFirefighter(Long id) {
        if (id != null) {
            personRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Boolean updatePerson(FirefighterDto firefighterDto) {
        if (firefighterDto == null || firefighterDto.getId() == null) return false;

        Firefighter firefighter = new Firefighter();
        FirefighterUtils firefighterUtils = new FirefighterUtils();
        firefighterUtils.createShortName(firefighterDto.getFirstName(), firefighterDto.getMidName(), firefighterDto.getLastName());
        firefighter.setShortName(firefighterUtils.getShortName());
        firefighter.setId(firefighterDto.getId());
        firefighter.setFirstName(firefighterDto.getFirstName());
        firefighter.setMidName(firefighterDto.getMidName());
        firefighter.setLastName(firefighterDto.getLastName());
        FireStation fireStation = personRepository.findFirefighterById(firefighterDto.getId()).getFireStation();
        firefighter.setFireStation(fireStation);
        if (firefighterDto.getTeamId() != null) {
            Optional<Team> team = teamRepository.findById(firefighterDto.getTeamId());
            firefighter.setTeam(team.get());
        } else {
            firefighter.setTeam(null);
        }
        Optional<Position> position = positionRepository.findById(firefighterDto.getPositionId());
        Optional<Rank> rank = rankRepository.findById(firefighterDto.getRankId());
        firefighter.setPosition(position.get());
        firefighter.setRank(rank.get());
        personRepository.save(firefighter);
        return true;
    }
}
