package com.alexfossa204.crmtenderbackendapp.database.repository;

import com.alexfossa204.crmtenderbackendapp.database.entity.employee_lot.EmployeeLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeLotRepository extends JpaRepository<EmployeeLot, Long> {
}
