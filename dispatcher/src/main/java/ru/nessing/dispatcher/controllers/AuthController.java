package ru.nessing.dispatcher.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nessing.dispatcher.utils.LoginRequest;

@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        try {
            // Попытка аутентификации пользователя
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            // Установка аутентификации в контексте безопасности
//            SecurityContextHolder.getContext().setAuthentication(authentication);

            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(authentication);

            // Явное сохранение контекста безопасности в сессии
            HttpSession session = request.getSession(true);
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, context);

            // Генерация JWT токена
//            String jwt = tokenProvider.generateToken(authentication);

            // Возврат токена в ответе
//            return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
            return ResponseEntity.ok(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            // В случае ошибки аутентификации возвращаем 401
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}

