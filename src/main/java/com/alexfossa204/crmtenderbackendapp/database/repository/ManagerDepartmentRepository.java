package com.alexfossa204.crmtenderbackendapp.database.repository;

import com.alexfossa204.crmtenderbackendapp.database.entity.ManagerDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ManagerDepartmentRepository extends JpaRepository<ManagerDepartment, Long> {

    Optional<ManagerDepartment> findManagerDepartmentByManager_ManagerUuid(UUID managerUuid);

}
