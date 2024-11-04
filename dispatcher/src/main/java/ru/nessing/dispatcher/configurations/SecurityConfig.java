package ru.nessing.dispatcher.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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


    @Autowired
    FireStationAuthManager fireStationAuthManager;
    @Bean
    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.builder().username("admin").password(encoder.encode("pass")).roles("ADMIN").build();
//        UserDetails user = User.builder().username("user").password(encoder.encode("pass")).roles("USER").build();
//        return new InMemoryUserDetailsManager(admin, user);
        return new CustomUserDetailsService();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/fire_station/", "/createUser").permitAll() //позволяет доступ ко всем в /public без авторизации
////                        .requestMatchers("/createUser").permitAll()
//                .anyRequest().authenticated()); // все остальные запросы требуют аутентификации
////                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll); // указываем настраивуемую страницу для входа
////                .formLogin(form -> form.loginPage("/login").permitAll()) // указываем настраивуемую страницу для входа
////                .logout(logout -> logout.permitAll());
////                .csrf(AbstractHttpConfigurer::disable); // отключение CSRF для упрощения (не рекомендуется в продакшен)
//        return http.build();

        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.requestMatchers("/createUser").permitAll()
                                .requestMatchers("/fire_station/fire_station.html", "/**").access(new FireStationAuthManager())
//                                .requestMatchers("/fire_station/fire_station.html").hasAnyRole("ADMIN", "FIRESTATION")
                                .anyRequest().authenticated()
                        )
                        .formLogin(form -> form.permitAll().successHandler(new CustomAuthSuccessHandler()))
//                        .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                        .exceptionHandling(ex -> ex.accessDeniedHandler(new CustomAccessDeniedHandler())) // исключение, если нет доступа
                        .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
