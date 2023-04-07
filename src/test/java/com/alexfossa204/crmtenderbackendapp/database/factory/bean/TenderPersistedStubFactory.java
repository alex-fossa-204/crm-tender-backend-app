package com.alexfossa204.crmtenderbackendapp.database.factory.bean;

import com.alexfossa204.crmtenderbackendapp.database.entity.Customer;
import com.alexfossa204.crmtenderbackendapp.database.entity.Tender;
import com.alexfossa204.crmtenderbackendapp.database.repository.CustomerRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.TenderRepository;
import org.springframework.stereotype.Component;

import static com.alexfossa204.crmtenderbackendapp.database.factory.TenderStubFactory.supplyTenderDefaultStub;

@Component
public class TenderPersistedStubFactory {

    private final TenderRepository tenderRepository;

    private final CustomerRepository customerRepository;

    public TenderPersistedStubFactory(TenderRepository tenderRepository, CustomerRepository customerRepository) {
        this.tenderRepository = tenderRepository;
        this.customerRepository = customerRepository;
    }

    public Tender supplyPersistedTender() {
        Customer customer = customerRepository.findAll().stream().findFirst().orElseThrow(() -> new RuntimeException("No value present"));
        return tenderRepository.save(supplyTenderDefaultStub(customer));
    }

}
