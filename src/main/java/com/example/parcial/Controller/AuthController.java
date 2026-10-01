package com.example.parcial.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.parcial.Config.auth;
import com.example.parcial.Dto.Request;
import com.example.parcial.Dto.Response;
import com.example.parcial.Service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final auth auth;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager, auth auth) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.auth = auth;
    }

    @PostMapping("/register")
    public ResponseEntity<Response.UserResponse> register(@RequestBody Request.RegisterRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<Response.UserResponse> login(@RequestBody Request.LoginRequest dto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
        } catch (AuthenticationException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email o contraseña incorrectos");
        }
        return ResponseEntity.ok(authService.findByEmail(dto.getEmail()));
    }

    // Devuelve el usuario logueado (requiere Basic Auth: email + contraseña)
    @GetMapping("/me")
    public ResponseEntity<Response.UserResponse> me() {
        return ResponseEntity.ok(new Response.UserResponse(auth.getCurrentUser()));
    }
}
