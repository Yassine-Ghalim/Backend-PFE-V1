package net.yassine.auth_service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import java.util.Arrays;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity (securedEnabled = true)
public class SecurityConfig {
  private JwtAuthConverter jwtAuthConverter;

    public SecurityConfig(JwtAuthConverter jwtAuthConverter) {
        this.jwtAuthConverter = jwtAuthConverter;
    }

    @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
       .cors(Customizer.withDefaults())
      .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Utilisation d'une gestion de session sans état
      .csrf(csrf -> csrf.disable()) // Désactivation de CSRF pour les API stateless
      .headers(h->h.frameOptions(fo->fo.disable()))
      .authorizeHttpRequests(ar -> ar
        .requestMatchers("/h2-console/**").permitAll() // Accès libre aux API
        .requestMatchers("/api/roles/**").hasAuthority("ADMIN")
              .anyRequest().authenticated()) // Authentification pour les autres requête
      .oauth2ResourceServer(o2->o2.jwt(jwt->jwt.jwtAuthenticationConverter(jwtAuthConverter)))
      .build();
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("*")); // Autorise toutes les origines
    configuration.setAllowedMethods(Arrays.asList("*")); // Méthodes HTTP autorisées
    configuration.setAllowedHeaders(Arrays.asList("*")); // Autorise tous les en-têtes
    configuration.setExposedHeaders(Arrays.asList("*")); // Expose tous les en-têtes
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration); // Applique CORS à tous les endpoints
    return source;
  }
}

