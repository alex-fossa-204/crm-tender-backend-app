package com.alexfossa204.crmtenderbackendapp.database;

import com.alexfossa204.crmtenderbackendapp.database.entity.Customer;
import com.alexfossa204.crmtenderbackendapp.database.entity.Lot;
import com.alexfossa204.crmtenderbackendapp.database.entity.Tender;
import com.alexfossa204.crmtenderbackendapp.database.factory.bean.TenderPersistedStubFactory;
import com.alexfossa204.crmtenderbackendapp.database.repository.CustomerRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.LotRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.TenderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.alexfossa204.crmtenderbackendapp.database.factory.LotStubFactory.supplyLotDefaultStub;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
public class LotRepositoryTest {

    @Autowired
    private LotRepository lotRepository;

    @Autowired
    private TenderRepository tenderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TenderPersistedStubFactory tenderPersistedStubFactory;

    @AfterEach
    void flushLotRepository() {
        lotRepository.deleteAll();
        tenderRepository.deleteAll();
    }

    @Test
    void when_lot_attempt_to_save_with_empty_tender() {
        Lot detachedLotEntity = supplyLotDefaultStub();

        Lot persistedLotEntity = lotRepository.save(detachedLotEntity);

        assertAll("Проверка сохранения тестовой записи",
                () -> assertThat(persistedLotEntity, is(notNullValue()))
        );
    }

    @Test
    void when_lot_attempt_to_save_with_persisted_tender() {

        Tender persistedTender = tenderPersistedStubFactory.supplyPersistedTender();

        Lot detachedLotEntity = supplyLotDefaultStub(persistedTender);

        Lot persistedLotEntity = lotRepository.save(detachedLotEntity);

        assertAll("Проверка сохранения тестовой записи",
                () -> assertThat(persistedLotEntity, is(notNullValue())),
                () -> assertThat(persistedLotEntity.getTender(), is(notNullValue()))
        );

    }

}
