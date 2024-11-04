package ru.nessing.dispatcher.configurations;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String redirectURL = request.getContextPath();

        // после успешной авторизации перенаправляем пользователя на указанный URL
        if (authentication.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_FIRESTATION"))) {
            redirectURL = "/fire_station/fire_station.html";
        } else if (authentication.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"))) {
            redirectURL = "/dispatcher/index.html";
        }

        response.sendRedirect(redirectURL);
    }
}
