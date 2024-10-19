package ru.nessing.dispatcher.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.nessing.dispatcher.entities.user.User;
import ru.nessing.dispatcher.repositories.AdminRepository;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        adminRepository.save(user);
    }

    public List<User> getAllUsers() {
        return adminRepository.findAll();
    }
}
