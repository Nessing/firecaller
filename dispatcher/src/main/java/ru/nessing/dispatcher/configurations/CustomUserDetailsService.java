package ru.nessing.dispatcher.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.nessing.dispatcher.entities.user.User;
import ru.nessing.dispatcher.repositories.UserRepository;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
     @Autowired
     private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Здесь должна быть ваша логика загрузки пользователя из базы данных
        // User user = userRepository.findByUsername(username);
        // if (user == null) {
        //     throw new UsernameNotFoundException("User not found");
        // }

        Optional<User> user = userRepository.findByUsername(username);
        return user.map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));

//        // Пример создания пользователя без реальной базы данных
//        if (!"user".equals(username)) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        // Создание CustomUserDetails с фиктивными данными
//        return new CustomUserDetails(
//                "user", // Имя пользователя
//                "{noop}password", // Пароль (без шифрования для примера специальный префикс {noop} для security)
//                true, // Аккаунт включен
//                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")) // Роли пользователя
//        );
    }
}
