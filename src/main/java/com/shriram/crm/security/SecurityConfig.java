package com.shriram.crm.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            // Allow access to Swagger UI and API documentation without authentication
            .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**", "/webjars/**").permitAll()
            // Allow access to registration and login endpoints without authentication
            .requestMatchers(HttpMethod.POST, "/api/user/register").permitAll()  // POST to /register
            .requestMatchers(HttpMethod.POST, "/api/user/login").permitAll()  // POST to /login
            // Other endpoints require authentication
            .anyRequest().authenticated()
            .and()
            // Apply basic authentication to other routes (excluding the ones above)
            .httpBasic();

        return http.build();
    }
}
