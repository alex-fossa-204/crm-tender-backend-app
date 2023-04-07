package com.alexfossa204.crmtenderbackendapp.database;

import com.alexfossa204.crmtenderbackendapp.database.entity.Customer;
import com.alexfossa204.crmtenderbackendapp.database.entity.Tender;
import com.alexfossa204.crmtenderbackendapp.database.extension.PostgresExtension;
import com.alexfossa204.crmtenderbackendapp.database.repository.CustomerRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.TenderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.alexfossa204.crmtenderbackendapp.database.factory.TenderStubFactory.supplyTenderDefaultStub;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
@ExtendWith(PostgresExtension.class)
class TenderRepositoryTest {

    @Autowired
    private TenderRepository tenderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @AfterEach
    void flushTenderTable() {
        tenderRepository.deleteAll();
    }


    @Test
    void when_tender_attempt_to_save_customer_null() {
        Tender detachedTenderEntity = supplyTenderDefaultStub();

        Tender persistedTenderEntity = tenderRepository.save(detachedTenderEntity);

        assertAll("Проверка сохранения тестовой записи",
                () -> assertThat(persistedTenderEntity, is(notNullValue()))
        );
    }

    @Test
    void when_tender_attempt_to_save_customer_not_empty() {

        Customer customer = customerRepository.findAll().stream().findFirst().orElseThrow(() -> new RuntimeException("No value present"));

        Tender detachedTenderEntity = supplyTenderDefaultStub(customer);

        Tender persistedTenderEntity = tenderRepository.save(detachedTenderEntity);

        assertAll("Проверка сохранения тестовой записи",
                () -> assertThat(persistedTenderEntity, is(notNullValue())),
                () -> assertThat(persistedTenderEntity.getCustomer(), is(notNullValue()))
        );
    }

}
