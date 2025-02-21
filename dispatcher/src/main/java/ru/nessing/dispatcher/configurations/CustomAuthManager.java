package ru.nessing.dispatcher.configurations;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;
import ru.nessing.dispatcher.utils.PermissionUser;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CustomAuthManager implements AuthorizationManager<RequestAuthorizationContext> {


    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext context) {
        PermissionUser permission = new PermissionUser();

        // Применять проверку только к HTML-страницам
//        if (!request.getServletPath().endsWith(".html")) {
//            return new AuthorizationDecision(true); // Разрешить доступ к статическим ресурсам
//        }

        String requestUrl = context.getRequest().getQueryString();
        Collection<? extends GrantedAuthority> roles = authentication.get().getAuthorities();
        for (GrantedAuthority role : roles) {
            if (role.getAuthority().contains("ROLE_ADMIN")) {
                return new AuthorizationDecision(true);
            }
        }
//        if (permission.isFireStation() && requestUrl != null && !requestUrl.isEmpty()) {
        if (permission.isFireStation()) {
            for (GrantedAuthority role : roles) {
                if (role.getAuthority().contains("ROLE_FIRESTATION")) {
//                    StringBuilder builder = new StringBuilder();
//                    Pattern pattern = Pattern.compile("\\d+");
//                    Matcher matcher = pattern.matcher(requestUrl);
//                    while (matcher.find()) {
//                        builder.append(matcher.group());
//                    }
//                    String numberStationUrl = builder.toString();
////            response.sendRedirect(request.getContextPath() + "/fire_station/fire_station.html?id=" + permission.getNumberOfFireStation());
//                    return new AuthorizationDecision(permission.getNumberOfFireStation().equals(numberStationUrl));
                    return new AuthorizationDecision(true);
                }
            }
        }
        return new AuthorizationDecision(false);
    }
}
