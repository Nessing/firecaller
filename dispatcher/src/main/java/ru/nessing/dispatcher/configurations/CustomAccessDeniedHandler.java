package ru.nessing.dispatcher.configurations;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.AccessDeniedHandler;
import ru.nessing.dispatcher.repositories.FireStationRepository;
import ru.nessing.dispatcher.utils.PermissionUser;

import java.io.IOException;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        PermissionUser permission = new PermissionUser();
//        if (permission.isFireStation()) {
//            response.sendRedirect(request.getContextPath() + "/fire_station/fire_station.html?id=" + permission.getNumberOfFireStation());
//        }
        // Если доступ не разрешен, то начинаем проверку,
        // какая была вызвана страница (fire_station)
        // и какую надо открывать (по id - берем из имени пользователя)
        String acceptHeader = request.getHeader("Accept");
        if (acceptHeader != null && acceptHeader.contains("text/html")) {
            if (permission.isFireStation()) {
                response.sendRedirect(request.getContextPath() + "/fire_station/fire_station.html?id=" + permission.getNumberOfFireStation());
                return;
            }
        }
        // Для всех остальных случаев возвращаем ошибку доступа
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
//        String permission = PermissionUser.getPermission();
//        if (permission != null && permission.toLowerCase().contains(("FireStation").toLowerCase())) {
//            StringBuilder builder = new StringBuilder();
//            Pattern pattern = Pattern.compile("\\d+");
//            Matcher matcher = pattern.matcher(permission);
//            while (matcher.find()) {
//                builder.append(matcher.group());
//            }
//            int number = Integer.parseInt(builder.toString());
//        }
    }
}
