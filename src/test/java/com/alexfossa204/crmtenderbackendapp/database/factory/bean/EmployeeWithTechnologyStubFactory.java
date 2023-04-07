package com.alexfossa204.crmtenderbackendapp.database.factory.bean;

import com.alexfossa204.crmtenderbackendapp.database.entity.Employee;
import com.alexfossa204.crmtenderbackendapp.database.entity.Technology;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.EmployeeTechnology;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.key.EmployeeTechnologyKey;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.state.TechnologyGradeType;
import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeTechnologyRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EmployeeWithTechnologyStubFactory {

    @Autowired
    private TechnologyRepository technologyRepository;

    @Autowired
    private EmployeeTechnologyRepository employeeTechnologyRepository;

    public EmployeeTechnology supplyEmployeeWithTechnologies(Employee persistedEmployee, String technologyName) {
        Technology persistedJavaTechnology1 = technologyRepository.findAll().stream()
                .filter(technology -> technology.getTechnologyName().equals(technologyName))
                .findFirst().orElseThrow(() -> new RuntimeException("Technology not found"));
        EmployeeTechnology detachedEmployeeTechnology = EmployeeTechnology.builder()
                .id(EmployeeTechnologyKey.of(
                        persistedEmployee.getId(), persistedJavaTechnology1.getId()
                ))
                .employeeEmployeeTechnology(persistedEmployee)
                .technologyEmployeeTechnology(persistedJavaTechnology1)
                .technologyGrade(TechnologyGradeType.J1)
                .gradeUpdateDate(LocalDateTime.now())
                .build();
        return employeeTechnologyRepository.save(detachedEmployeeTechnology);
    }

}
