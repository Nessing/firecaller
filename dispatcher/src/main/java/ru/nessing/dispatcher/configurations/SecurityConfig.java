package ru.nessing.dispatcher.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails admin = User.builder().username("admin").password(encoder.encode("pass")).roles("ADMIN").build();
        UserDetails user = User.builder().username("user").password(encoder.encode("pass")).roles("USER").build();
        return new InMemoryUserDetailsManager(admin, user);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http.authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/public/**").permitAll()  // Доступ для всех к публичным ресурсам
//                        .anyRequest().authenticated()               // Все остальные запросы требуют аутентификации
//                ).formLogin(form -> form
//                        .loginPage("/login")                        // Страница логина
//                        .permitAll()                                // Доступ к странице логина для всех
//                ).logout(logout -> logout.permitAll()                                // Доступ к логауту для всех
//                );
//
//        return http.build();
        http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/fire_station/**").permitAll() //позволяет доступ ко всем в /public без авторизации
                        .requestMatchers("/createUser").permitAll()
                .anyRequest().authenticated()) // все остальные запросы требуют аутентификации
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll) // указываем настраивуемую страницу для входа
//                .formLogin(form -> form.loginPage("/login").permitAll()) // указываем настраивуемую страницу для входа
                .logout(logout -> logout.permitAll())
                .csrf(AbstractHttpConfigurer::disable); // отключение CSRF для упрощения (не рекомендуется в продакшен)
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
