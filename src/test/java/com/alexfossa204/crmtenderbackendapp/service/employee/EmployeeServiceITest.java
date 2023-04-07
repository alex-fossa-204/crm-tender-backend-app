package com.alexfossa204.crmtenderbackendapp.service.employee;

import com.alexfossa204.crmtenderbackendapp.database.entity.Employee;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.EmployeeTechnology;
import com.alexfossa204.crmtenderbackendapp.database.extension.PostgresExtension;
import com.alexfossa204.crmtenderbackendapp.database.factory.bean.EmployeeWithTechnologyStubFactory;
import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeRepository;
import com.alexfossa204.crmtenderbackendapp.service.employee.domain.EmployeeService;
import com.alexfossa204.crmtenderbackendapp.service.employee.domain.dto.EmployeeDomainModel;
import com.alexfossa204.crmtenderbackendapp.service.employee.domain.mapper.EmployeeToEmployeeDomainModelMapper;
import com.alexfossa204.crmtenderbackendapp.service.employee.domain.dto.EmployeeTechnologyDomain;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
@ExtendWith(PostgresExtension.class)
class EmployeeServiceITest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeWithTechnologyStubFactory employeeWithTechnologyStubFactory;

    @Autowired
    private EmployeeToEmployeeDomainModelMapper employeeToEmployeeDomainModelMapper;

    @AfterEach
    void afterEachFlushUsedTables() {
        employeeWithTechnologyStubFactory.flushTestObjects();
    }

    @Test
    void when_attempt_to_update_existing_employee() {
        employeeWithTechnologyStubFactory.supplyEmployeeWithTechnology("Java");

        Employee persistedEmployee = employeeRepository.findAll().stream().findFirst().orElseThrow(() -> new RuntimeException("No value present"));
        var persistedEmployeeUuid = persistedEmployee.getEmployeeUuid();
        var persistedOldEmployeeFirstname = persistedEmployee.getFirstname();
        var persistedOldEmployeeLastname = persistedEmployee.getLastname();

        EmployeeDomainModel employeeDomainModel = employeeToEmployeeDomainModelMapper.mapEmployeeEntityToEmployeeDto(persistedEmployee);
        employeeDomainModel.setFirstname("Arnold");
        employeeDomainModel.setLastname("Schwartzeneeger");

        EmployeeDomainModel employeeDomainModelServiceResult = employeeService.updateEmployee(employeeDomainModel);

        assertAll("Проверка отсутствия дубликатов записи", () ->assertThat(employeeRepository.findAll().size(), is(equalTo(1))));

        assertAll("Проверка корректности маппинга полей",
                () -> assertThat(employeeDomainModelServiceResult.getEmployeeUuid(), is(equalTo(persistedEmployeeUuid))),
                () -> assertThat(employeeDomainModelServiceResult.getFirstname(), not(equalTo(persistedOldEmployeeFirstname))),
                () -> assertThat(employeeDomainModelServiceResult.getLastname(), not(equalTo(persistedOldEmployeeLastname)))
        );
    }

    @Test
    void when_attemptToMapEmployeeTechnologiesToDto() {
        EmployeeTechnology employeeTechnologyPersisted = employeeWithTechnologyStubFactory.supplyEmployeeWithTechnology("Java");


        Employee employeeEntity = employeeRepository.findById(employeeTechnologyPersisted.getEmployeeEmployeeTechnology().getId()).orElseThrow(() -> new RuntimeException("No value"));

        List<EmployeeTechnologyDomain> employeeTechnologyDomains =
                employeeEntity.getEmployeeTechnologies().stream()
                .map(technology -> EmployeeTechnologyDomain.of(technology.getTechnologyEmployeeTechnology().getTechnologyName(), technology.getTechnologyGrade().name()))
                .toList();

        System.out.println("hello");

    }

}
