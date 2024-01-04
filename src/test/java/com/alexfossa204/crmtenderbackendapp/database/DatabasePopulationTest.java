package com.alexfossa204.crmtenderbackendapp.database;

import com.alexfossa204.crmtenderbackendapp.database.factory.ManagerStubFactory;
import com.alexfossa204.crmtenderbackendapp.database.repository.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static com.alexfossa204.crmtenderbackendapp.database.factory.LotStubFactory.supplyLotDefaultStub;
import static com.alexfossa204.crmtenderbackendapp.database.factory.TenderStubFactory.supplyTenderDefaultStub;
import static org.assertj.core.api.Assertions.*;

@ConditionalOnProperty(prefix = "feature-toggle.enabled-database-population-script", value = "true")
@SpringBootTest
public class DatabasePopulationTest {


    @Autowired
    private TenderRepository tenderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LotRepository lotRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void populateTenders() {

        var persistedRole = roleRepository.findAll().stream().findFirst().orElseThrow();

        var persistedTenderManager = managerRepository.save(ManagerStubFactory.supplyManagerDefaultStub(persistedRole)); // TODO добавить роли
        var persistedLotManager = managerRepository.save(ManagerStubFactory.supplyManagerDefaultStub(persistedRole)); // TODO добавить роли

        var tenderInitialGenQuantity = 26;
        var lotInitialGenQuantity = 31;

        var customer = customerRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No value present"));

        IntStream.range(0, tenderInitialGenQuantity).forEach(tender -> {
            var persistedTender = tenderRepository.save(supplyTenderDefaultStub(customer, persistedTenderManager));

            IntStream.range(0,lotInitialGenQuantity).forEach(lot -> {
                var persistedLot = lotRepository.save(supplyLotDefaultStub(persistedTender, persistedLotManager));
            });

        });

        IntStream.range(0, 25).forEach(manager -> {
            managerRepository.save(ManagerStubFactory.supplyManagerDefaultStub(persistedRole));
        });

        var actualTenders = tenderRepository.findAll();
        assertThat(actualTenders.size())
                .isEqualTo(tenderInitialGenQuantity);

    }

    @Test
    void controlTenderSaveBatch() {
        var actualTenders = tenderRepository.findAll();
        assertThat(actualTenders).isNotEmpty();
    }

}
