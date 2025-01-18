package ru.nessing.dispatcher.configurations;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.nessing.dispatcher.entities.user.Permission;
import ru.nessing.dispatcher.entities.user.Role;
import ru.nessing.dispatcher.entities.user.User;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;
    private User user;
    @Getter
    private Role role;

    public CustomUserDetails(User user) {
        this.user = user;
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.role = user.getRole();
    }

    public Permission getPermission() {
        return this.user.getPermission();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getRoleName()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // или ваша логика
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // или ваша логика
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // или ваша логика
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
