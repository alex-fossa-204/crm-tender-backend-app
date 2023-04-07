package com.alexfossa204.crmtenderbackendapp.database;

import com.alexfossa204.crmtenderbackendapp.database.entity.Employee;
import com.alexfossa204.crmtenderbackendapp.database.entity.Technology;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.EmployeeTechnology;
import com.alexfossa204.crmtenderbackendapp.database.factory.bean.EmployeeWithTechnologyStubFactory;
import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeRepository;

import static org.hamcrest.MatcherAssert.assertThat;

import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeTechnologyRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.TechnologyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.alexfossa204.crmtenderbackendapp.database.factory.EmployeeStubFactory.supplyEmployeeDefaultStub;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TechnologyRepository technologyRepository;

    @Autowired
    private EmployeeTechnologyRepository employeeTechnologyRepository;

    @Autowired
    private EmployeeWithTechnologyStubFactory employeeWithTechnologyStubFactory;

    @AfterEach
    void flushEmployeeTable() {
        employeeTechnologyRepository.deleteAll();
        employeeRepository.deleteAll();
    }

    @Test
    void whenEmployeeAttemptToSave() {

        Employee persistedEmployee = employeeRepository.save(supplyEmployeeDefaultStub());

        assertAll("Проверка сохранения тестовой записи",
                () -> assertThat(persistedEmployee, is(notNullValue()))
        );

    }

    @Test
    void whenEmployeeAttemptToSaveWithTechnologies() {

        List<Technology> persistedTechnologies = technologyRepository.findAll();

        Employee detachedEmployee = supplyEmployeeDefaultStub(
                List.of(
                        persistedTechnologies.stream()
                                .filter(technology -> technology.getTechnologyName().equals("Java"))
                                .findFirst().orElseThrow(() -> new RuntimeException("Technology not found")),
                        persistedTechnologies.stream()
                                .filter(technology -> technology.getTechnologyName().equals("Angular"))
                                .findFirst().orElseThrow(() -> new RuntimeException("Technology not found"))
                )
        );

        Employee persistedEmployee = employeeRepository.save(detachedEmployee);

        assertAll("Проверка сохранения тестовой записи",
                () -> assertThat(persistedEmployee, is(notNullValue()))
        );

        List<EmployeeTechnology> employeeTechnologyList = employeeTechnologyRepository.findAll();
        assertAll("Проверка сохранения тестовой записи",
                () -> assertThat(employeeTechnologyList, is(notNullValue()))
        );

    }

    @Test
    void when_attempt_set_for_existing_employee_single_technology_entity() {
        Employee persistedEmployee1 = employeeRepository.save(supplyEmployeeDefaultStub());
        assertAll("Проверка сохранения тестовой записи employee",
                () -> assertThat(persistedEmployee1, is(notNullValue()))
        );
        EmployeeTechnology detachedEmployeeJavaTechnology1 = employeeWithTechnologyStubFactory.supplyEmployeeWithTechnologies(persistedEmployee1, "Java");
        EmployeeTechnology persistedEmployeeJavaTechnology1 = employeeTechnologyRepository.save(detachedEmployeeJavaTechnology1);
        assertAll("Проверка сохранения тестовой записи EmployeeTechnology",
                () -> assertThat(persistedEmployeeJavaTechnology1, is(notNullValue()))
        );
        EmployeeTechnology detachedEmployeeAngularTechnology1 = employeeWithTechnologyStubFactory.supplyEmployeeWithTechnologies(persistedEmployee1, "Angular");
        EmployeeTechnology persistedEmployeeAngularTechnology1 = employeeTechnologyRepository.save(detachedEmployeeAngularTechnology1);
        assertAll("Проверка сохранения тестовой записи EmployeeTechnology",
                () -> assertThat(persistedEmployeeAngularTechnology1, is(notNullValue()))
        );

    }

}
