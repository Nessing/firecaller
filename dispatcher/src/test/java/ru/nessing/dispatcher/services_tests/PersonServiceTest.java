package ru.nessing.dispatcher.services_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nessing.dispatcher.entities.DTOs.FirefighterDTO;
import ru.nessing.dispatcher.entities.FireStation;
import ru.nessing.dispatcher.entities.Firefighter;
import ru.nessing.dispatcher.entities.Position;
import ru.nessing.dispatcher.repositories.FireStationRepository;
import ru.nessing.dispatcher.repositories.PersonRepository;
import ru.nessing.dispatcher.services.PersonService;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PersonServiceTest {
    private final String FIRST_NAME = "Иван";
    private final String MID_NAME = "Павлович";
    private final String SURNAME = "Васильев";
    private final String SHORT_NAME = "И. П. Васильев";

    private final FireStation FIRE_STATION = FireStation.builder()
            .id(1L)
            .name("1 часть")
            .location("Народная улица")
            .numberStation(1)
            .shortName("1 ПСЧ")
            .build();

    private final Position POSITION = Position.builder()
            .id(1L)
            .name("Пожарный")
            .build();

    private final Firefighter FIREFIGHTER = Firefighter.builder()
            .id(1L)
            .firstName(FIRST_NAME)
            .midName(MID_NAME)
            .lastName(SURNAME)
            .shortName(SHORT_NAME)
            .fireStation(FIRE_STATION)
            .position(POSITION)
            .build();

    @Mock
    private PersonRepository personRepository;

    @Mock
    private FireStationRepository fireStationRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    public void createShortNameOfPerson() {
        FirefighterDTO firefighterDTO = new FirefighterDTO();
        firefighterDTO.createShortName(FIRST_NAME, MID_NAME, SURNAME);
        Assertions.assertEquals(firefighterDTO.getShortName(), SHORT_NAME);
    }

    @Test
    public void addPerson() {
        Mockito.when(personRepository.save(FIREFIGHTER)).thenReturn(FIREFIGHTER);
        Mockito.when(fireStationRepository.findFireStationById(1L)).thenReturn(FIRE_STATION);
        personService.addFirefighter(FIREFIGHTER);
        Assertions.assertEquals(personService.addFirefighter(FIREFIGHTER), FIREFIGHTER);
    }

    @Test
    public void getPerson() {
        personRepository.save(FIREFIGHTER);
        List<Firefighter> firefighters = new ArrayList<>();
        firefighters.add(FIREFIGHTER);
        Mockito.when(personRepository.findFirefightersByFireStation_IdOrderByTeam(1L)).thenReturn(firefighters);
        Assertions.assertEquals(personService.getFirefighters(1L).get(0), FIREFIGHTER);
    }
}
