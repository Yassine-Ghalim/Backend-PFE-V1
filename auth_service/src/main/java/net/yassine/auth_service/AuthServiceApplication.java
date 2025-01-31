package net.yassine.auth_service;


import net.yassine.auth_service.Entity.Role;
import net.yassine.auth_service.Repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class AuthServiceApplication {



  public static void main(String[] args) {
    SpringApplication.run(AuthServiceApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(RoleRepository roleRepository) {
    return args -> {
      // Create roles with actual parameters
      Role role1 = new Role("admin");
      Role role2 = new Role("developer");
      Role role3 = new Role("ops");

      // Save the roles to the database
      roleRepository.saveAll(List.of(role1, role2, role3));  // Save multiple roles
    };
  }



}
