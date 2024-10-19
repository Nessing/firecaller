package ru.nessing.dispatcher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nessing.dispatcher.entities.user.User;
import ru.nessing.dispatcher.services.AdminService;

@RestController
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/createUser")
    public String CreateUser(@RequestBody User user) {
        adminService.createUser(user);
        return "user " + user.getUsername() + " is created";
    }

    public void getAllUsers() {

    }
}
