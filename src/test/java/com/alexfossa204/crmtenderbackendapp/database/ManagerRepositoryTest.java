package com.alexfossa204.crmtenderbackendapp.database;

import com.alexfossa204.crmtenderbackendapp.database.extension.PostgresExtension;
import com.alexfossa204.crmtenderbackendapp.database.repository.ManagerRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.RoleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.alexfossa204.crmtenderbackendapp.database.factory.ManagerStubFactory.supplyManagerDefaultStub;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
@ExtendWith(PostgresExtension.class)
class ManagerRepositoryTest {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private RoleRepository roleRepository;

    @AfterEach
    void flushManagerTable() {
        managerRepository.deleteAll();
    }

    @Test
    void when_attempt_to_save_manager_with_persisted_role() {

        var persistedRole = roleRepository.findAll().stream().findFirst().orElseThrow(() -> new RuntimeException("No value present"));

        var detachedManagerEntity = supplyManagerDefaultStub(persistedRole);

        var persistedManagerEntity = managerRepository.save(detachedManagerEntity);

        assertAll("Проверка сохранения тестовой записи",
                () -> Assertions.assertThat(persistedManagerEntity).isNotNull(),
                () -> Assertions.assertThat(persistedManagerEntity.getRole()).isEqualTo(persistedRole)
        );

    }

}
