package ru.nessing.dispatcher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nessing.dispatcher.repositories.FireStationRepository;
import ru.nessing.dispatcher.repositories.PersonRepository;
import ru.nessing.dispatcher.entities.DTOs.FirefighterDTO;
import ru.nessing.dispatcher.entities.FireStation;
import ru.nessing.dispatcher.entities.Firefighter;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final FireStationRepository fireStationRepository;

    @Autowired
    public PersonService(PersonRepository personRepository, FireStationRepository fireStationRepository) {
        this.personRepository = personRepository;
        this.fireStationRepository = fireStationRepository;
    }

    public List<Firefighter> getFirefighters(Long fireStation) {
        return personRepository.findFirefightersByFireStation_IdOrderByTeam(fireStation);
    }

    public Boolean addFirefighter(Firefighter firefighter) {
        FirefighterDTO firefighterDTO = new FirefighterDTO();
        firefighterDTO.createShortName(firefighter.getFirstName(), firefighter.getMidName(), firefighter.getLastName());
        firefighter.setId(null);
        firefighter.setShortName(firefighterDTO.getShortName());
        if (firefighter.getPosition() == null) {
            return false;
        }
        if (firefighter.getFireStation() == null) {
            return false;
        }
        FireStation fireStation = fireStationRepository.findFireStationById(firefighter.getFireStation().getId());
        firefighter.setFireStation(fireStation);
        personRepository.save(firefighter);
        return true;
    }

    public Boolean deleteFirefighter(Long id) {
        if (id != null) {
            personRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Boolean updatePerson(Firefighter firefighter) {
        FirefighterDTO firefighterDTO = new FirefighterDTO();
        firefighterDTO.createShortName(firefighter.getFirstName(), firefighter.getMidName(), firefighter.getLastName());
        firefighter.setShortName(firefighterDTO.getShortName());
        personRepository.save(firefighter);
        return true;
    }
}
