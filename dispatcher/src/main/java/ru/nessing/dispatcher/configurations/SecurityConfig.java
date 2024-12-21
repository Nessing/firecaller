package ru.nessing.dispatcher.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import ru.nessing.dispatcher.JWT.JwtAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


    @Autowired
    CustomAuthManager customAuthManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.builder().username("admin").password(encoder.encode("pass")).roles("ADMIN").build();
//        UserDetails user = User.builder().username("user").password(encoder.encode("pass")).roles("USER").build();
//        return new InMemoryUserDetailsManager(admin, user);
        return new CustomUserDetailsService();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/createUser", "/login").permitAll()
                                .requestMatchers("/getCars/1").access(customAuthManager)
                                .anyRequest().authenticated()
                        )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .authenticationManager(authManager(http))
                .authenticationProvider(authenticationProvider())
                .exceptionHandling(ex -> ex.accessDeniedHandler(new CustomAccessDeniedHandler())) // исключение, если нет доступа
                        .build();
    }


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/fire_station/", "/createUser").permitAll() //позволяет доступ ко всем в /public без авторизации
//////                        .requestMatchers("/createUser").permitAll()
////                .anyRequest().authenticated()); // все остальные запросы требуют аутентификации
//////                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll); // указываем настраивуемую страницу для входа
//////                .formLogin(form -> form.loginPage("/login").permitAll()) // указываем настраивуемую страницу для входа
//////                .logout(logout -> logout.permitAll());
//////                .csrf(AbstractHttpConfigurer::disable); // отключение CSRF для упрощения (не рекомендуется в продакшен)
////        return http.build();
//
//        return http.csrf(AbstractHttpConfigurer::disable)
//                .cors(Customizer.withDefaults())
////                .cors(cors -> cors.configurationSource(request -> {
////                    CorsConfiguration config = new CorsConfiguration();
////                    config.setAllowedOrigins(List.of("http://localhost:5173"));
////                    config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
////                    config.setAllowedHeaders(List.of("*"));
////                    config.setAllowCredentials(true);
////                    return config;
////                }))
//                .authorizeHttpRequests(auth -> auth.requestMatchers("/createUser", "/login").permitAll()
//                                .requestMatchers("/getCars/1").access(customAuthManager)
////                                .requestMatchers("/fire_station/fire_station.html", "/**").access(customAuthManager)
////                                .requestMatchers("/fire_station/fire_station.html").hasAnyRole("ADMIN", "FIRESTATION")
//                                .anyRequest().authenticated()
//                )
//                .authenticationManager(authManager(http))
////                .formLogin(form -> form.loginProcessingUrl("/login").permitAll())
////                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
////                .addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
////                        .formLogin(form -> form.permitAll().successHandler(new CustomAuthSuccessHandler()))
////                        .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
//                .exceptionHandling(ex -> ex.accessDeniedHandler(new CustomAccessDeniedHandler())) // исключение, если нет доступа
//                .build();
//    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:5173"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
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
