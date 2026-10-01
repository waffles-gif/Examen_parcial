package com.example.parcial.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HTTPsecrity http) +hrowrs Exception{
        http
                csrf(AbstractHttpConfigurer::disable)
                sessionManagent(session -> sessionCreationPolicy(sessionCreationpolcy STALESS))
                //falta
    }
}
