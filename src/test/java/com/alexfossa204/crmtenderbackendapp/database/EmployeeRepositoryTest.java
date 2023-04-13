package com.alexfossa204.crmtenderbackendapp.database;

import com.alexfossa204.crmtenderbackendapp.database.entity.Employee;
import com.alexfossa204.crmtenderbackendapp.database.entity.Technology;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.EmployeeTechnology;
import com.alexfossa204.crmtenderbackendapp.database.extension.PostgresExtension;
import com.alexfossa204.crmtenderbackendapp.database.factory.bean.EmployeeWithTechnologyStubFactory;
import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeRepository;

import static org.hamcrest.MatcherAssert.assertThat;

import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeTechnologyRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.TechnologyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.IntStream;

import static com.alexfossa204.crmtenderbackendapp.database.factory.EmployeeStubFactory.supplyEmployeeDefaultStub;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
@ExtendWith(PostgresExtension.class)
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
        EmployeeTechnology detachedEmployeeJavaTechnology1 = employeeWithTechnologyStubFactory.supplyEmployeeWithTechnology(persistedEmployee1, "Java");
        EmployeeTechnology persistedEmployeeJavaTechnology1 = employeeTechnologyRepository.save(detachedEmployeeJavaTechnology1);
        assertAll("Проверка сохранения тестовой записи EmployeeTechnology",
                () -> assertThat(persistedEmployeeJavaTechnology1, is(notNullValue()))
        );
        EmployeeTechnology detachedEmployeeAngularTechnology1 = employeeWithTechnologyStubFactory.supplyEmployeeWithTechnology(persistedEmployee1, "Angular");
        EmployeeTechnology persistedEmployeeAngularTechnology1 = employeeTechnologyRepository.save(detachedEmployeeAngularTechnology1);
        assertAll("Проверка сохранения тестовой записи EmployeeTechnology",
                () -> assertThat(persistedEmployeeAngularTechnology1, is(notNullValue()))
        );

    }

    @Test
    void when_pageable_employee_list_attempt_to_read() {
        int stubQuantity = 10;
        IntStream.range(0, stubQuantity).forEach(action -> employeeRepository.save(supplyEmployeeDefaultStub()));

        List<Employee> persistedEmployees = employeeRepository.findAll();

        int pageCounter = 0;
        int pageSize = 3;
        List<Employee> employeePage = employeeRepository.findAll(PageRequest.of(pageCounter, pageSize)).getContent();
        assertAll("Проверка страницы",
                () -> assertThat(employeePage.size(), is(equalTo(pageSize))),
                () -> assertThat(employeePage.size(), not(persistedEmployees.size()))
        );
    }

}
