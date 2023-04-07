package com.alexfossa204.crmtenderbackendapp.database;

import com.alexfossa204.crmtenderbackendapp.database.entity.Employee;
import com.alexfossa204.crmtenderbackendapp.database.entity.Technology;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.EmployeeTechnology;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.EmployeeTechnologyKey;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.TechnologyGradeType;
import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeRepository;

import static org.hamcrest.MatcherAssert.assertThat;

import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeTechnologyRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.TechnologyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
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
        EmployeeTechnology persistedEmployeeJavaTechnology1 = employeeTechnologyRepository.save(detachedEmployeeJavaTechnology1);
        assertAll("Проверка сохранения тестовой записи EmployeeTechnology",
                () -> assertThat(persistedEmployeeJavaTechnology1, is(notNullValue()))
        );

        Technology persistedAngularTechnology1 = technologyRepository.findAll().stream()
                .filter(technology -> technology.getTechnologyName().equals("Angular"))
                .findFirst().orElseThrow(() -> new RuntimeException("Technology not found"));
        EmployeeTechnology detachedEmployeeAngularTechnology1 = EmployeeTechnology.builder()
                .id(EmployeeTechnologyKey.of(
                        persistedEmployee1.getId(), persistedAngularTechnology1.getId()
                ))
                .employeeEmployeeTechnology(persistedEmployee1)
                .technologyEmployeeTechnology(persistedAngularTechnology1)
                .technologyGrade(TechnologyGradeType.J1)
                .gradeUpdateDate(LocalDateTime.now())
                .build();
        EmployeeTechnology persistedEmployeeAngularTechnology1 = employeeTechnologyRepository.save(detachedEmployeeAngularTechnology1);
        assertAll("Проверка сохранения тестовой записи EmployeeTechnology",
                () -> assertThat(persistedEmployeeAngularTechnology1, is(notNullValue()))
        );

        Employee persistedEmployee2 = employeeRepository.save(supplyEmployeeDefaultStub());
        assertAll("Проверка сохранения тестовой записи employee",
                () -> assertThat(persistedEmployee2, is(notNullValue()))
        );

        Technology persistedJavaTechnology2 = technologyRepository.findAll().stream()
                .filter(technology -> technology.getTechnologyName().equals("Java"))
                .findFirst().orElseThrow(() -> new RuntimeException("Technology not found"));
        EmployeeTechnology detachedEmployeeJavaTechnology2 = EmployeeTechnology.builder()
                .id(EmployeeTechnologyKey.of(
                        persistedEmployee2.getId(), persistedJavaTechnology2.getId()
                ))
                .employeeEmployeeTechnology(persistedEmployee2)
                .technologyEmployeeTechnology(persistedJavaTechnology2)
                .technologyGrade(TechnologyGradeType.J1)
                .gradeUpdateDate(LocalDateTime.now())
                .build();
        EmployeeTechnology persistedEmployeeJavaTechnology2 = employeeTechnologyRepository.save(detachedEmployeeJavaTechnology2);
        assertAll("Проверка сохранения тестовой записи EmployeeTechnology",
                () -> assertThat(persistedEmployeeJavaTechnology2, is(notNullValue()))
        );

        Technology persistedAngularTechnology2 = technologyRepository.findAll().stream()
                .filter(technology -> technology.getTechnologyName().equals("Angular"))
                .findFirst().orElseThrow(() -> new RuntimeException("Technology not found"));
        EmployeeTechnology detachedEmployeeAngularTechnology2 = EmployeeTechnology.builder()
                .id(EmployeeTechnologyKey.of(
                        persistedEmployee2.getId(), persistedAngularTechnology2.getId()
                ))
                .employeeEmployeeTechnology(persistedEmployee2)
                .technologyEmployeeTechnology(persistedAngularTechnology2)
                .technologyGrade(TechnologyGradeType.J1)
                .gradeUpdateDate(LocalDateTime.now())
                .build();
        EmployeeTechnology persistedEmployeeAngularTechnology2 = employeeTechnologyRepository.save(detachedEmployeeAngularTechnology2);
        assertAll("Проверка сохранения тестовой записи EmployeeTechnology",
                () -> assertThat(persistedEmployeeAngularTechnology2, is(notNullValue()))
        );


        Employee employeePersistedWithTechnologies = employeeRepository.findAll().stream().findFirst().orElseThrow(() -> new RuntimeException("Not found"));
        assertAll("Проверка сохранения тестовой записи EmployeeTechnology",
                () -> assertThat(employeePersistedWithTechnologies, is(notNullValue()))
        );

        List<EmployeeTechnology> employeeTechnologies = employeePersistedWithTechnologies.getEmployeeTechnologies();
        assertAll("Проверка сохранения тестовой записи EmployeeTechnology",
                () -> assertThat(employeeTechnologies, is(notNullValue()))
        );

    }

}
