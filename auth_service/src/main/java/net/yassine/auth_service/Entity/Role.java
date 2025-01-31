package net.yassine.auth_service.Entity;

import jakarta.persistence.*;
import lombok.*;



@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  // Default constructor (required by JPA)
  public Role() {}

  // Constructor with the name
  public Role(String name) {
    this.name = name;
  }

  // Getters and setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

