package net.yassine.auth_service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
      .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Utilisation d'une gestion de session sans état
      .csrf(csrf -> csrf.disable()) // Désactivation de CSRF pour les API stateless
      .headers(h->h.frameOptions(fo->fo.disable()))
      .authorizeHttpRequests(ar -> ar
        .requestMatchers("/api/**","/h2-console/**").permitAll() // Accès libre aux API
        .anyRequest().authenticated()) // Authentification pour les autres requêtes
      .build();
  }

}
