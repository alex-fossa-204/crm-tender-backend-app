package com.alexfossa204.crmtenderbackendapp.database;

import com.alexfossa204.crmtenderbackendapp.database.factory.DepartmentStubFactory;
import com.alexfossa204.crmtenderbackendapp.database.factory.ManagerStubFactory;
import com.alexfossa204.crmtenderbackendapp.database.repository.DepartmentRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.ManagerRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.RoleRepository;
import com.alexfossa204.crmtenderbackendapp.model.ContactData;
import com.alexfossa204.crmtenderbackendapp.model.PositionData;
import com.alexfossa204.crmtenderbackendapp.model.UserData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.stream.IntStream;


@ConditionalOnProperty(prefix = "feature-toggle.enabled-database-population-script", value = "true")
@SpringBootTest
public class DatabasePopulationTest {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void populateTenders() {

        final var persistedRole = roleRepository.findAll().stream().findFirst().orElseThrow();

        IntStream.range(0, 30).forEach(manager -> {
            managerRepository.save(ManagerStubFactory.supplyManagerDefaultStub(persistedRole));
        });
        final var leaderEntity1 = managerRepository.findAll().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Данные менеджера отсутсвуют"));

        departmentRepository.save(
                DepartmentStubFactory.supplyDepartmentStub(
                        "Project Management Department",
                        "PMD",
                        leaderEntity1
                )
        );

        final var leaderEntity2 = managerRepository.findAll().stream()
                .filter(manager -> !manager.getManagerUuid().equals(leaderEntity1.getManagerUuid()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Данные менеджера отсутсвуют"));

        departmentRepository.save(
                DepartmentStubFactory.supplyDepartmentStub(
                        "Administration Department",
                        "AD",
                        leaderEntity2
                )
        );
    }

    @Test
    public void when_findAllDepartments() {
        final var departments = departmentRepository.findAll();
        System.out.println(departments);
    }

}
