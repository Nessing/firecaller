package ru.nessing.firecaller.dispatcher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nessing.firecaller.dispatcher.services.PersonService;
import ru.nessing.firecaller.entities.Firefighter;

import java.util.List;

@RestController
public class PersonController {
    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/getFirefighters/{fireStation}")
    public List<Firefighter> getFirefightersOfStation(@PathVariable Long fireStation) {
        return service.getFirefighters(fireStation);
    }

    @PostMapping("/addPerson")
    public Boolean addFirefighter(@RequestBody Firefighter firefighter) {
        return service.addFirefighter(firefighter);
    }

    @PostMapping("/deletePerson")
    public Boolean deleteFirefighter(@RequestBody Long id) {
        return service.deleteFirefighter(id);
    }

    @PostMapping("/updatePerson")
    public Boolean updatePerson(@RequestBody Firefighter firefighter) {
        return service.updatePerson(firefighter);
    }
}
