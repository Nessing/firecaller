package ru.nessing.dispatcher.configurations;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private boolean enabled;
    private List<GrantedAuthority> authorities;

    public CustomUserDetails(String username, String password, boolean enabled, List<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
        return enabled;
    }
}
