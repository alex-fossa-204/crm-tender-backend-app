package com.alexfossa204.crmtenderbackendapp.database;

import com.alexfossa204.crmtenderbackendapp.database.entity.Department;
import com.alexfossa204.crmtenderbackendapp.database.entity.ManagerDepartment;
import com.alexfossa204.crmtenderbackendapp.database.entity.Role;
import com.alexfossa204.crmtenderbackendapp.database.factory.DepartmentStubFactory;
import com.alexfossa204.crmtenderbackendapp.database.factory.ManagerStubFactory;
import com.alexfossa204.crmtenderbackendapp.database.repository.DepartmentRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.ManagerDepartmentRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.ManagerRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.RoleRepository;
import com.alexfossa204.crmtenderbackendapp.model.ContactData;
import com.alexfossa204.crmtenderbackendapp.model.PositionData;
import com.alexfossa204.crmtenderbackendapp.model.UserData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
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

    @Autowired
    private ManagerDepartmentRepository managerDepartmentRepository;

    @Test
    void populate() {
        var role = Role.builder()
                .roleName("User")
                .id(UUID.fromString("0f04bccf-a2ec-4526-81f0-1020cced671b"))
                .build();
        roleRepository.save(role);

        final var persistedRole = roleRepository.findAll().stream()
                .findFirst()
                .orElseThrow();
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


        final var manager = managerRepository.findAll()
                .stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Не найдено ни одной записи"));
        final var department = departmentRepository.findAll().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найдено ни одной записи"));

        final var managerDep = ManagerDepartment.builder()
                .manager(manager)
                .department(department)
                .createTimestamp(LocalDateTime.now())
                .updateTimestamp(LocalDateTime.now())
                .build();
        managerDepartmentRepository.save(managerDep);


    }


}
