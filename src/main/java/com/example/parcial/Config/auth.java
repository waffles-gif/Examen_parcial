package com.example.parcial.Config;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.parcial.Entity.User;
import com.example.parcial.Repository.UserRepository;

@Component
public class auth {

    private final UserRepository userRepository;

    public auth(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getCurrentEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()
                || authentication instanceof AnonymousAuthenticationToken) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No has iniciado sesión");
        }
        return authentication.getName();
    }

    public User getCurrentUser() {
        return userRepository.findByEmail(getCurrentEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario no encontrado"));
    }

    public Long getCurrentUserId() {
        return getCurrentUser().getId();
    }

    public boolean hasRole(User.Role role) {
        return getCurrentUser().getRole() == role;
    }
}
