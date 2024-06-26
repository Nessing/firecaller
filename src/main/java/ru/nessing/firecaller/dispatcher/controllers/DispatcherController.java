package ru.nessing.firecaller.dispatcher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nessing.firecaller.dispatcher.services.DispatcherService;
import ru.nessing.firecaller.entities.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class DispatcherController {

    @Autowired
    private DispatcherService service;

    @GetMapping("/getFireStations")
    public List<FireStation> getAllFireStations() {
        return service.getAllFireStations();
    }

    @GetMapping("/getFireStation/{id}")
    public Optional<FireStation> getFireStation(@PathVariable Long id) {
        return service.getFireStation(id);
    }

    @GetMapping("/getPositions")
    public Map<Long, String> getPositions() {
        return service.getPositions();
    }

    @GetMapping("/getAllPositions")
    public List<Position> getAllPositions() {
        return service.getAllPositions();
    }

    @GetMapping("/getFirefighters/{fireStation}")
    public List<Firefighter> getFirefightersOfStation(@PathVariable int fireStation) {
        return service.getFirefighters(fireStation);
    }

    @GetMapping("/getSquare/{fireStation}")
    public List<Square> getSquare(@PathVariable int fireStation) {
        return service.getSquare(fireStation);
    }

    @PostMapping("/addPerson")
    public Boolean addFirefighter(@RequestBody Firefighter firefighter) {
        return service.addFirefighter(firefighter);
    }

    @PostMapping("/deletePerson")
    public Boolean deleteFirefighter(@RequestBody Long id) {
        return service.deleteFirefighter(id);
    }

//    @GetMapping("/createTest")
//    public Firefighter create() {
//        return service.createTestFirefighter();
//    }

    @PostMapping("/createPosition")
    public Boolean addPosition(@RequestBody Position position) {
        return service.addPosition(position.getName());
    }

    @PostMapping("/removePosition")
    public Boolean deletePosition(@RequestBody Position position) {
        return service.deletePosition(position);
    }

    @GetMapping("/getFire/{id}")
    public Firefighter getFire(@PathVariable Long id) {
        return service.getFire(id);
    }

//    @GetMapping
//    public String getAllFireStations() {
//        return service.getAllFireStationLocal();
////        return "mainPage";
//    }
//    @RequestMapping("/hello")
//    @ResponseBody
//    public List<FireStation> getFireStations() {
//        return service.getAllFireStations();
//    }
//    public String mainPage() {
//        return "mainPage";
//    }

//    @GetMapping("/{str}")
//    public String checkPage(@PathVariable String str) {
//        return "Проверка успешна " + str;
//    }
}
