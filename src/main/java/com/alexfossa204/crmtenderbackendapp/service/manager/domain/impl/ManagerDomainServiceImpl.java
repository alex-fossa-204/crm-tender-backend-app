package com.alexfossa204.crmtenderbackendapp.service.manager.domain.impl;

import com.alexfossa204.crmtenderbackendapp.controller.rest.commons.dto.delete.BaseDeleteResponse;
import com.alexfossa204.crmtenderbackendapp.controller.rest.manager.dto.ManagerPageResponse;
import com.alexfossa204.crmtenderbackendapp.controller.rest.manager.dto.ManagerResponse;
import com.alexfossa204.crmtenderbackendapp.database.repository.ManagerDepartmentRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.ManagerRepository;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.ManagerDomainService;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.dto.ManagerDomainModel;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.mapper.ManagerDepartmentToManagerDomainModelMapper;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.mapper.ManagerToManagerDomainModelMapper;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.mapper.ManagerToManagerResponseMapper;
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

    private final ManagerToManagerResponseMapper managerToManagerResponseMapper;

    private final ManagerRepository managerRepository;

    private final ManagerDepartmentRepository managerDepartmentRepository;

    private final ManagerDepartmentToManagerDomainModelMapper managerDepartmentToManagerDomainModelMapper;

    @Override
    public ManagerPageResponse selectManagerPage(PageRequest pageRequest) {
        return ManagerPageResponse.of(
                managerRepository.count(),
                managerDepartmentRepository.findAll(pageRequest)
                        .stream()
                        .map(managerDepartmentToManagerDomainModelMapper::mapManagerEntityToManagerDomainModel)
                        .toList()
        );
    }

    @Override
    public ManagerDomainModel updateManager(ManagerDomainModel manager) {
        throw new NotImplementedException("Method in not implemented");
    }

    @Override
    public BaseDeleteResponse deleteManager(String managerUuid) {
        final var managerDepartment = managerDepartmentRepository.findManagerDepartmentByManager_ManagerUuid(UUID.fromString(managerUuid))
                .orElseThrow(() -> new RuntimeException(String.format("Менеджер с uuid = %s - не найден", managerUuid)));
        managerDepartmentRepository.deleteById(managerDepartment.getId());

        managerRepository.deleteById(managerDepartment.getManager().getId());
        return BaseDeleteResponse.of(
                managerUuid,
                String.format("Менеджер с uuid = %s - удален успешно", managerUuid)
        );
    }

    @Override
    public ManagerResponse findManagerByPublicId(String managerUuid) {
        return managerToManagerResponseMapper.mapManagerEntityToManagerResponse(
                managerDepartmentRepository.findManagerDepartmentByManager_ManagerUuid(UUID.fromString(managerUuid))
                        .orElseThrow(() -> new RuntimeException(String.format("Менеджер с uuid = %s - не найден", managerUuid)))
        );
    }
}
