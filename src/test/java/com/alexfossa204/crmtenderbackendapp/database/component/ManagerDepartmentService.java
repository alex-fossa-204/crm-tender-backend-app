package com.alexfossa204.crmtenderbackendapp.database.component;

import com.alexfossa204.crmtenderbackendapp.database.entity.ManagerDepartment;
import com.alexfossa204.crmtenderbackendapp.database.repository.ManagerDepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManagerDepartmentService {

    @Autowired
    private ManagerDepartmentRepository managerDepartmentRepository;

    @Transactional
    public ManagerDepartment saveManagerDepartment(ManagerDepartment managerDepartment) {
        return managerDepartmentRepository.save(managerDepartment);
    }

}
