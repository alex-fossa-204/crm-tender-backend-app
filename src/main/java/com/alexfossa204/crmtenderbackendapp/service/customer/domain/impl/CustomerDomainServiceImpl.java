package com.alexfossa204.crmtenderbackendapp.service.customer.domain.impl;

import com.alexfossa204.crmtenderbackendapp.controller.rest.customer.dto.CustomerPageResponse;
import com.alexfossa204.crmtenderbackendapp.database.repository.CustomerRepository;
import com.alexfossa204.crmtenderbackendapp.service.customer.domain.CustomerDomainService;
import com.alexfossa204.crmtenderbackendapp.service.customer.domain.mapper.CustomerToCustomerDomainModelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
public class CustomerDomainServiceImpl implements CustomerDomainService {

    private final CustomerToCustomerDomainModelMapper customerToCustomerDomainModelMapper;

    private final CustomerRepository customerRepository;

    @Transactional
    @Override
    public CustomerPageResponse selectCustomerPage(PageRequest pageRequest) {
        return CustomerPageResponse.of(
                customerRepository.count(),
                customerRepository.findAll(pageRequest).getContent()
                        .stream()
                        .map(customerToCustomerDomainModelMapper::mapCustomerEntityToCustomerDomainModel)
                        .toList()
        );
    }
}
