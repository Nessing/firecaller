package ru.nessing.dispatcher.services_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nessing.dispatcher.entities.FireStation;
import ru.nessing.dispatcher.repositories.FireStationRepository;
import ru.nessing.dispatcher.services.FireStationService;

import java.util.List;

@SpringBootTest
public class FireStationServiceIntegrationTest {
    @Autowired
    private FireStationService fireStationService; // сервис, который будет тестироваться

    @Autowired
    private FireStationRepository fireStationRepository; // реальная реализация репозитория

    @Test
    public void testGetAllFireStations() {
        // Получаем реальные данные из БД
        List<FireStation> fireStations = fireStationRepository.findAll();

        // Вызываем метод сервиса
        List<FireStation> result = fireStationService.getAllFireStations();

        // Проверяем, что результат не пустой и содержит ожидаемые данные
        Assertions.assertNotNull(result);
        Assertions.assertEquals(fireStations.size(), result.size());
    }
}
