package ru.nessing.dispatcher.services_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nessing.dispatcher.entities.FireStation;
import ru.nessing.dispatcher.repositories.FireStationRepository;
import ru.nessing.dispatcher.services.FireStationService;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class FireStationServiceTest {

    @Mock
    private FireStationRepository fireStationRepository;

    @InjectMocks
    private FireStationService fireStationService;

    @Test
    public void testGetAllFireStations() {
        List<FireStation> fireStations = new ArrayList<>();
        FireStation fireStation = FireStation.builder()
                .id(1L)
                .name("1 часть")
                .location("Народная улица")
                .numberStation(1)
                .shortName("1 ПСЧ")
                .build();
        fireStations.add(fireStation);

        fireStationRepository.save(fireStation);
        Mockito.when(fireStationRepository.findAll()).thenReturn(fireStations);

        System.out.println(fireStations);
        System.out.println(fireStationService.getAllFireStations());
        Assertions.assertEquals(fireStations, fireStationService.getAllFireStations());
    }
}
