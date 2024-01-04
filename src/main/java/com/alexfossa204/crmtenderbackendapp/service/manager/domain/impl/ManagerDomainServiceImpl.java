package com.alexfossa204.crmtenderbackendapp.service.manager.domain.impl;

import com.alexfossa204.crmtenderbackendapp.controller.rest.base.dto.delete.BaseDeleteResponse;
import com.alexfossa204.crmtenderbackendapp.controller.rest.manager.dto.ManagerPageResponse;
import com.alexfossa204.crmtenderbackendapp.database.repository.ManagerRepository;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.ManagerDomainService;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.dto.ManagerDomainModel;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.mapper.ManagerToManagerDomainModelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class ManagerDomainServiceImpl implements ManagerDomainService {

    private final ManagerToManagerDomainModelMapper managerToManagerDomainModelMapper;

    private final ManagerRepository managerRepository;

    @Override
    public ManagerPageResponse selectManagerPage(PageRequest pageRequest) {
        return ManagerPageResponse.of(
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

    @Transactional
    @Override
    public BaseDeleteResponse deleteManager(String managerUuid) {
        val currentManager = managerRepository.findByManagerUuid(UUID.fromString(managerUuid))
                .orElseThrow(() -> new RuntimeException(String.format("Менеджер с uuid = %s - не найден", managerUuid)));
        managerRepository.deleteById(currentManager.getId());
        return BaseDeleteResponse.of(
                managerUuid,
                String.format("Менеджер с uuid = %s - удален успешно", managerUuid)
        );
    }
}
