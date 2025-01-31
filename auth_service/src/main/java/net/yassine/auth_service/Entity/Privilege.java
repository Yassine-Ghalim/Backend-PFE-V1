package net.yassine.auth_service.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.Builder;


@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder @ToString
public class Privilege {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
}
