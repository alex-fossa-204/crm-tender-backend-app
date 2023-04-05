package com.alexfossa204.crmtenderbackendapp.database.repository;

import com.alexfossa204.crmtenderbackendapp.database.entity.technology.EmployeeTechnology;
import com.alexfossa204.crmtenderbackendapp.database.entity.technology.EmployeeTechnologyKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTechnologyRepository extends JpaRepository<EmployeeTechnology, EmployeeTechnologyKey> {
}
