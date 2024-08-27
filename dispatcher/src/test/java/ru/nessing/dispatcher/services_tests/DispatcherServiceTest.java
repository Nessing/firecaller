package ru.nessing.dispatcher.services_tests;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nessing.dispatcher.utils.FireStationInfo;
import ru.nessing.dispatcher.services.DispatcherService;

import java.util.List;


@SpringBootTest
public class DispatcherServiceTest {

    @Autowired
    private DispatcherService dispatcherService;

    @Test
    public void testGetSquares() {
        List<FireStationInfo> fireStationInfos = dispatcherService.getFireStationsAndSquares();
        System.out.println(fireStationInfos);
    }

}
