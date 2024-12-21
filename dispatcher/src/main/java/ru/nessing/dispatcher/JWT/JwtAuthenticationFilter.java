package ru.nessing.dispatcher.JWT;

import io.jsonwebtoken.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.userdetails.User;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;



public class JwtAuthenticationFilter extends OncePerRequestFilter {
    // Создаем секретный ключ. Убедитесь, что ключ достаточно длинный для используемого алгоритма.
    private final SecretKey secretKey = Keys.hmacShaKeyFor("YourSecretKeyYourSecretKeyYourSecretKey".getBytes(StandardCharsets.UTF_8));
//    private final SecretKey secretKey = Keys.hmacShaKeyFor("YourSecretKeyYourSecretKeyYourSecretKey".getBytes()); // Используйте свой секретный ключ

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String jwt = authorizationHeader.substring(7);

//            try {
//                Claims claims = Jwts.parser()
//                        .setSigningKey(secretKey)
//                        .parseClaimsJws(jwt)
//                        .getBody();
//
//                String username = claims.getSubject();
//
//                String username = jwsClaims.getBody().getSubject(); // Получаем subject из токена
//
//                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                    // Создаем объект Authentication на основе токена
//                    User user = new User(username, "", Collections.emptyList());
//                    Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//
//            } catch (Exception e) {
//                // Обработка ошибок валидации токена
//                System.out.println("Invalid JWT signature: " + e.getMessage());
//            }
        }

        filterChain.doFilter(request, response);
    }
}
