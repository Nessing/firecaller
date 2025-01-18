package ru.nessing.dispatcher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.nessing.dispatcher.entities.user.User;
import ru.nessing.dispatcher.services.AdminService;

import java.util.List;

@RestController
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/createUser")
    public String CreateUser(@RequestBody User user) {
        System.out.println(user);
        adminService.createUser(user);
        return "user " + user.getUsername() + " is created";
    }

    @GetMapping("/getAllUsers")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }
}
