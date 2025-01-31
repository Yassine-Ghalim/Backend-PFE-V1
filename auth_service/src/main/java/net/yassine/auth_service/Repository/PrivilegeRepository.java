package net.yassine.auth_service.Repository;

import net.yassine.auth_service.Entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {}

