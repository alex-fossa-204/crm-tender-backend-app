package com.alexfossa204.crmtenderbackendapp.database;

import com.alexfossa204.crmtenderbackendapp.database.factory.ManagerStubFactory;
import com.alexfossa204.crmtenderbackendapp.database.repository.CustomerRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.LotRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.ManagerRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.TenderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static com.alexfossa204.crmtenderbackendapp.database.factory.LotStubFactory.supplyLotDefaultStub;
import static com.alexfossa204.crmtenderbackendapp.database.factory.TenderStubFactory.supplyTenderDefaultStub;

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

    @Test
    public void populateTenders() {

        var persistedTenderManager = managerRepository.save(ManagerStubFactory.supplyManagerDefaultStub()); // TODO добавить роли
        var persistedLotManager = managerRepository.save(ManagerStubFactory.supplyManagerDefaultStub()); // TODO добавить роли

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

        var actualTenders = tenderRepository.findAll();
        Assertions.assertThat(actualTenders.size())
                .isEqualTo(tenderInitialGenQuantity);

    }

    @Test
    void controlTenderSaveBatch() {
        var actualTenders = tenderRepository.findAll();
        Assertions.assertThat(actualTenders).isNotEmpty();
    }

}
