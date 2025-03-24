package ru.nessing.dispatcher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nessing.dispatcher.entities.DTOs.FirefighterDto;
import ru.nessing.dispatcher.services.PersonService;
import ru.nessing.dispatcher.entities.Firefighter;
import ru.nessing.dispatcher.utils.PermissionUser;

import java.util.List;
import java.util.Map;

@RestController
public class PersonController {
    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/getPersons/{fireStation}")
    public List<Firefighter> getPersonsOfStation(@PathVariable Long fireStation) {
        return service.getPersons(fireStation);
    }

    @GetMapping("/getPersons")
    public List<Firefighter> getPersons() {
        PermissionUser permission = new PermissionUser();
        if (permission.getNumberOfFireStation() != null) {
            return service.getPersons(Long.parseLong(permission.getNumberOfFireStation()));
        }
        return null;
    }

    @PostMapping("/createPerson")
    public Firefighter createFirefighter(@RequestBody FirefighterDto firefighter) {
        return service.createFirefighter(firefighter);
    }

    @PostMapping("/deletePerson")
    public Boolean deleteFirefighter(@RequestBody Map<String, Long> request) {
        Long personId = request.get("personId");
        return service.deleteFirefighter(personId);
    }

    @PostMapping("/updatePerson")
    public Boolean updatePerson(@RequestBody FirefighterDto firefighter) {
        return service.updatePerson(firefighter);
    }
}
