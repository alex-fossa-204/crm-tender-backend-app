package com.alexfossa204.crmtenderbackendapp.database.repository;

import com.alexfossa204.crmtenderbackendapp.database.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    Optional<Role> findByRoleName(String roleName);

}
