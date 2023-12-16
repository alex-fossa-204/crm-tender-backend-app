package com.alexfossa204.crmtenderbackendapp.service.manager.domain.impl;

import com.alexfossa204.crmtenderbackendapp.controller.rest.employee.dto.EmployeePageResponse;
import com.alexfossa204.crmtenderbackendapp.database.repository.ManagerRepository;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.ManagerDomainService;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.dto.ManagerDomainModel;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.mapper.ManagerToManagerDomainModelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class ManagerDomainServiceImpl implements ManagerDomainService {

    private final ManagerToManagerDomainModelMapper managerToManagerDomainModelMapper;

    private final ManagerRepository managerRepository;

    @Override
    public EmployeePageResponse selectManagerPage(PageRequest pageRequest) {
        return EmployeePageResponse.of(
                managerRepository.count(),
                managerRepository.findAll(pageRequest).getContent()
                        .stream()
                        .map(managerToManagerDomainModelMapper::mapManagerEntityToManagerDomainModel)
                        .toList()
        );
    }

    @Override
    public ManagerDomainModel updateManager(ManagerDomainModel manager) {
        throw new NotImplementedException("Method in not implemented");
    }

    @Override
    public void deleteManager(ManagerDomainModel manager) {
        throw new NotImplementedException("Method in not implemented");
    }
}
