package ru.nessing.dispatcher.utils;

import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.nessing.dispatcher.configurations.CustomUserDetails;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class PermissionUser {

    private static String permission;

    public PermissionUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUserDetails details) {
            permission = details.getPermission().getName();
        }
    }

    public static String getPermission() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof CustomUserDetails details) {
            return details.getPermission().getName();
        }
        return null;
    }

    public String getNumberOfFireStation() {
        if (permission.contains("_")) {
            String number = permission.split("_")[1];
            StringBuilder builder = new StringBuilder();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(permission);
            while (matcher.find()) {
                builder.append(matcher.group());
            }
            return number;
        } return null;
    }

    public boolean isFireStation() {
        return permission != null && permission.toLowerCase().contains(("FireStation").toLowerCase());
    }
}
