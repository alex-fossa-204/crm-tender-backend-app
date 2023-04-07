package com.alexfossa204.crmtenderbackendapp.database.factory.bean;

import com.alexfossa204.crmtenderbackendapp.database.entity.Employee;
import com.alexfossa204.crmtenderbackendapp.database.entity.Technology;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.EmployeeTechnology;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.key.EmployeeTechnologyKey;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.state.TechnologyGradeType;
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

    public EmployeeTechnology supplyEmployeeWithTechnology(String technologyName) {
        Employee persistedEmployee = employeeRepository.save(supplyEmployeeDefaultStub());
        return supplyEmployeeWithTechnology(persistedEmployee, technologyName);
    }

    public EmployeeTechnology supplyEmployeeWithTechnology(Employee persistedEmployee, String technologyName) {
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

    //TODO заменить в тестах обращения к репозиторям при удалении на этот метод
    public void flushTestObjects() {
        employeeTechnologyRepository.deleteAll();
        employeeRepository.deleteAll();
    }

}
