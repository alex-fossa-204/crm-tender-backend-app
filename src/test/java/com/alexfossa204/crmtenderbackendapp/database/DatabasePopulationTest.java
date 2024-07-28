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

        var persistedRole = roleRepository.findAll().stream().findFirst().orElseThrow();

        IntStream.range(0, 30).forEach(manager -> {
            managerRepository.save(ManagerStubFactory.supplyManagerDefaultStub(persistedRole));
        });


        departmentRepository.save(
                DepartmentStubFactory.supplyDepartmentStub(
                        "Project Management Department",
                        "PMD",
                        supplyLeader("Иванов", "Иван", "Иванович")
                )
        );

        departmentRepository.save(
                DepartmentStubFactory.supplyDepartmentStub(
                        "Administration Department",
                        "AD",
                        supplyLeader("Степанов", "Двимтрий", "Николаевич")
                )
        );

    }

    private UserData supplyLeader(String lastname, String firstname, String middlename) {
        var position = new PositionData.PositionDataBuilder()
                .withShortcut("PC")
                .withFullPosition("Project Coordinator")
                .withGrade("J2")
                .withCompanyName("Aston")
                .build();
        var positionSet = new HashSet<>();
        positionSet.add(position);

        var leaderContactSet = new HashSet<>();
        leaderContactSet.add(new ContactData.ContactDataBuilder()
                .withContactType("Skype")
                .withContactValue("bigBossSkype")
                .build());
        leaderContactSet.add(new ContactData.ContactDataBuilder()
                .withContactType("VK Teams")
                .withContactValue("bigBossTeams")
                .build());
        leaderContactSet.add(new ContactData.ContactDataBuilder()
                .withContactType("Email")
                .withContactValue("bigBossEmail")
                .build());
        leaderContactSet.add(new ContactData.ContactDataBuilder()
                .withContactType("Phone")
                .withContactValue("+375 29 456-45-84")
                .build());

        return new UserData.UserDataBuilder()
                .withFirstName(firstname)
                .withMiddleName(middlename)
                .withLastName(lastname)
                .withBirthDate(LocalDate.now().toString())
                .withContacts(leaderContactSet)
                .withPositions(positionSet)
                .build();
    }

}
