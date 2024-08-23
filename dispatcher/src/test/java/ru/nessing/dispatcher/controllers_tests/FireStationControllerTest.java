package ru.nessing.dispatcher.controllers_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class FireStationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllFireStations() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getFireStations")).andExpect(MockMvcResultMatchers.status().isOk());
        System.out.println("getAllFireStations");
    }

    @Test
    public void testGetFireStation() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getFireStation/{id}", 1)).andExpect(MockMvcResultMatchers.status().isOk());
        System.out.println("getFireStation");
    }

    @Test
    public void testAddition() {
        int result = 2 + 2;
        Assertions.assertEquals(4, result);
        System.out.println("yes");
    }
}
