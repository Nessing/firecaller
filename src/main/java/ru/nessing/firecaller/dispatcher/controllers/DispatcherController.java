package ru.nessing.firecaller.dispatcher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nessing.firecaller.dispatcher.services.DispatcherService;
import ru.nessing.firecaller.entities.*;

import java.util.List;
import java.util.Map;

@RestController
public class DispatcherController {

    @Autowired
    private DispatcherService service;

    @GetMapping("/getFireStations")
    public List<FireStation> getAllFireStations() {
        return service.getAllFireStations();
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
    public Firefighter addFirefighter(@RequestBody Firefighter firefighter) {
        return service.addFirefighter(firefighter);
    }

//    @GetMapping("/createTest")
//    public Firefighter create() {
//        return service.createTestFirefighter();
//    }

    @PostMapping("/createPosition")
    public Position addPosition(@RequestBody Position position) {
        return service.addPosition(position.getName());
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
