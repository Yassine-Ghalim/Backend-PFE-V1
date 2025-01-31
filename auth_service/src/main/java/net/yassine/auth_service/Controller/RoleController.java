package net.yassine.auth_service.Controller;

import net.yassine.auth_service.Entity.Role;
import net.yassine.auth_service.Repository.RoleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

  private final RoleRepository roleRepository;

  public RoleController(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  // Get all roles
  @GetMapping
  public ResponseEntity<List<Role>> getAllRoles() {
    return ResponseEntity.ok(roleRepository.findAll());
  }

  // Create a new role
  @PostMapping
  public ResponseEntity<Role> createRole(@RequestBody Role role) {
    // Lorsque le rôle est créé, l'ID est généré automatiquement dans le constructeur de Role
    Role savedRole = roleRepository.save(role);
    return ResponseEntity.ok(savedRole);
  }



}
