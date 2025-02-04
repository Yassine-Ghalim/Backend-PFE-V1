package net.yassine.auth_service.Controller;

import net.yassine.auth_service.Entity.Role;
import net.yassine.auth_service.Repository.RoleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class RoleController {

  private final RoleRepository roleRepository;

  public RoleController(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  // Get all roles
  @GetMapping("/roles")
  public ResponseEntity<List<Role>> getAllRoles() {
    return ResponseEntity.ok(roleRepository.findAll());
  }

  // Get role by ID
  @GetMapping("/roles/{id}")
  public Role productById(@PathVariable Long id){
    return roleRepository.findById(id).get();
  }

  // Create a new role
  @PostMapping
  public ResponseEntity<Role> createRole(@RequestBody Role role) {
    // Lorsque le rôle est créé, l'ID est généré automatiquement dans le constructeur de Role
    Role savedRole = roleRepository.save(role);
    return ResponseEntity.ok(savedRole);
  }

@GetMapping("/auth")
  public Authentication authentication(Authentication authentication) {
    return authentication;
  }

}
