package com.alexfossa204.crmtenderbackendapp.database;

import com.alexfossa204.crmtenderbackendapp.database.entity.Employee;
import com.alexfossa204.crmtenderbackendapp.database.entity.Lot;
import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;
import com.alexfossa204.crmtenderbackendapp.database.entity.Tender;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_lot.EmployeeLot;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_lot.key.EmployeeLotKey;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_lot.state.EmployeeLotState;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.EmployeeTechnology;
import com.alexfossa204.crmtenderbackendapp.database.factory.bean.EmployeeWithTechnologyStubFactory;
import com.alexfossa204.crmtenderbackendapp.database.factory.bean.ManagerPersistedStubFactory;
import com.alexfossa204.crmtenderbackendapp.database.factory.bean.TenderPersistedStubFactory;
import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeLotRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeTechnologyRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.LotRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.ManagerRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.TenderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static com.alexfossa204.crmtenderbackendapp.database.factory.EmployeeStubFactory.supplyEmployeeDefaultStub;
import static com.alexfossa204.crmtenderbackendapp.database.factory.LotStubFactory.supplyLotDefaultStub;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
public class EmployeeLotsRepositoryTest {

    @Autowired
    private EmployeeLotRepository employeeLotRepository;

    @Autowired
    private TenderRepository tenderRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LotRepository lotRepository;

    @Autowired
    private EmployeeTechnologyRepository employeeTechnologyRepository;

    @Autowired
    private TenderPersistedStubFactory tenderPersistedStubFactory;

    @Autowired
    private EmployeeWithTechnologyStubFactory employeeWithTechnologyStubFactory;

    @Autowired
    private ManagerPersistedStubFactory managerPersistedStubFactory;

    @Autowired
    private ManagerRepository managerRepository;

    @AfterEach
    void flushTables() {
        employeeLotRepository.deleteAll();
        lotRepository.deleteAll();
        tenderRepository.deleteAll();
        employeeTechnologyRepository.deleteAll();
        employeeRepository.deleteAll();
        managerRepository.deleteAll();
    }

    @Test
    void when_employeeLot_attempt_to_save() {
        EmployeeTechnology persistedEmployeeWithTechnology = employeeWithTechnologyStubFactory.supplyEmployeeWithTechnologies(
                employeeRepository.save(supplyEmployeeDefaultStub()), "Java"
        );


        Employee persistedEmployee = persistedEmployeeWithTechnology.getEmployeeEmployeeTechnology();

        Manager persistedManager = managerPersistedStubFactory.supplyPersistedManagerWithRoleStub();

        Tender persistedTender = tenderPersistedStubFactory.supplyPersistedTender();
        Lot persistedLot = lotRepository.save(supplyLotDefaultStub(persistedTender));

        EmployeeLot employeeLot =
                EmployeeLot.of(
                        EmployeeLotKey.of(persistedEmployee.getId(), persistedLot.getId()),
                        persistedEmployee,
                        persistedLot,
                        persistedManager,
                        EmployeeLotState.АКТИВНЫЙ,
                        LocalDateTime.now(),
                        LocalDateTime.now()
                );

        EmployeeLot persistedEmployeeLot = employeeLotRepository.save(employeeLot);
        assertAll("Проверка сохранения тестовой записи",
                () -> assertThat(persistedEmployeeLot, is(notNullValue()))
        );

        Employee employeeWithLots = employeeRepository.findAll().stream()
                .findFirst().orElseThrow(() -> new RuntimeException("No value present"));
        assertAll("Проверка сохранения тестовой записи",
                () -> assertThat(employeeWithLots, is(notNullValue())),
                () -> assertThat(employeeWithLots.getEmployeeLots(), is(notNullValue()))
        );

        EmployeeLot employeeLot1 = employeeWithLots.getEmployeeLots().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No Value present"));
        Tender employeeTender = employeeLot1.getLotEmployeeLot().getTender();
        assertAll("Проверка связи лота в котором участвует сотрудник с тендером",
                () -> assertThat(employeeTender, is(notNullValue()))
        );
    }

}
