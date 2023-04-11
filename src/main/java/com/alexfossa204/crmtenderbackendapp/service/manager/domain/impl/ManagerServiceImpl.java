package com.alexfossa204.crmtenderbackendapp.service.manager.domain.impl;

import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;
import com.alexfossa204.crmtenderbackendapp.database.repository.ManagerRepository;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.ManagerService;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.dto.ManagerDomainModel;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.mapper.ManagerToManagerDomainModelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerToManagerDomainModelMapper managerToManagerDomainModelMapper;

    private final ManagerRepository managerRepository;

    @Override
    public List<ManagerDomainModel> findAllManagers() {
        return managerRepository.findAll().stream()
                .map(managerToManagerDomainModelMapper::mapManagerEntityToManagerDomainModel)
                .toList();
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
