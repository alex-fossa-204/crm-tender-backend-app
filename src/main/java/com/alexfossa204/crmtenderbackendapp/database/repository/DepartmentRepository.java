package com.alexfossa204.crmtenderbackendapp.database.repository;

import com.alexfossa204.crmtenderbackendapp.database.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
