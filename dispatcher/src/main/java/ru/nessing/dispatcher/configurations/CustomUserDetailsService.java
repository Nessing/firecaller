package ru.nessing.dispatcher.configurations;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

//@Service
public class CustomUserDetailsService implements UserDetailsService {
    // Здесь можно использовать ваш репозиторий для доступа к базе данных
    // private final UserRepository userRepository;

    // public CustomUserDetailsService(UserRepository userRepository) {
    //     this.userRepository = userRepository;
    // }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Здесь должна быть ваша логика загрузки пользователя из базы данных
        // User user = userRepository.findByUsername(username);
        // if (user == null) {
        //     throw new UsernameNotFoundException("User not found");
        // }

        // Пример создания пользователя без реальной базы данных
        if (!"user".equals(username)) {
            throw new UsernameNotFoundException("User not found");
        }

        // Создание CustomUserDetails с фиктивными данными
        return new CustomUserDetails(
                "user", // Имя пользователя
                "{noop}password", // Пароль (без шифрования для примера специальный префикс {noop} для security)
                true, // Аккаунт включен
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")) // Роли пользователя
        );
    }
}
