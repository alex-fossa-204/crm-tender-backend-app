package com.alexfossa204.crmtenderbackendapp.database.factory.bean;

import com.alexfossa204.crmtenderbackendapp.database.entity.Employee;
import com.alexfossa204.crmtenderbackendapp.database.entity.Technology;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.EmployeeTechnology;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.EmployeeTechnologyKey;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.TechnologyGradeType;
import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeTechnologyRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.alexfossa204.crmtenderbackendapp.database.factory.EmployeeStubFactory.supplyEmployeeDefaultStub;

@Component
public class EmployeeWithTechnologyStubFactory {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TechnologyRepository technologyRepository;

    @Autowired
    private EmployeeTechnologyRepository employeeTechnologyRepository;

    public EmployeeTechnology supplyEmployeeWithTechnologies() {
        Employee persistedEmployee1 = employeeRepository.save(supplyEmployeeDefaultStub());
        Technology persistedJavaTechnology1 = technologyRepository.findAll().stream()
                .filter(technology -> technology.getTechnologyName().equals("Java"))
                .findFirst().orElseThrow(() -> new RuntimeException("Technology not found"));
        EmployeeTechnology detachedEmployeeJavaTechnology1 = EmployeeTechnology.builder()
                .id(EmployeeTechnologyKey.of(
                        persistedEmployee1.getId(), persistedJavaTechnology1.getId()
                ))
                .employeeEmployeeTechnology(persistedEmployee1)
                .technologyEmployeeTechnology(persistedJavaTechnology1)
                .technologyGrade(TechnologyGradeType.J1)
                .gradeUpdateDate(LocalDateTime.now())
                .build();
        return employeeTechnologyRepository.save(detachedEmployeeJavaTechnology1);
    }

}
