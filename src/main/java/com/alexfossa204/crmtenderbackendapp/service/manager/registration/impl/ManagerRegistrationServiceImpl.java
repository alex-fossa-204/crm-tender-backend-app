package com.alexfossa204.crmtenderbackendapp.service.manager.registration.impl;

import com.alexfossa204.crmtenderbackendapp.database.entity.ManagerDepartment;
import com.alexfossa204.crmtenderbackendapp.database.repository.DepartmentRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.ManagerDepartmentRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.ManagerRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.RoleRepository;
import com.alexfossa204.crmtenderbackendapp.service.department.domain.mapper.DepartmentToDepartmentDomainModelMapper;
import com.alexfossa204.crmtenderbackendapp.service.manager.registration.ManagerRegistrationService;
import com.alexfossa204.crmtenderbackendapp.service.manager.registration.dto.ManagerRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.manager.registration.dto.ManagerRegistrationResponse;
import com.alexfossa204.crmtenderbackendapp.service.manager.registration.mapper.ManagerRegistrationDataToManagerDataMapper;
import com.alexfossa204.crmtenderbackendapp.service.manager.registration.mapper.ManagerToManagerRegistrationRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ManagerRegistrationServiceImpl implements ManagerRegistrationService {

    private final ManagerToManagerRegistrationRequestMapper managerToManagerRegistrationRequestMapper;

    private final ManagerRegistrationDataToManagerDataMapper managerRegistrationDataToManagerDataMapper;

    private final DepartmentToDepartmentDomainModelMapper departmentToDepartmentDomainModelMapper;

    private final ManagerRepository managerRepository;

    private final DepartmentRepository departmentRepository;

    private final RoleRepository roleRepository;

    private final ManagerDepartmentRepository managerDepartmentRepository;

    @Override
    public ManagerRegistrationResponse registerManager(ManagerRegistrationRequest managerRegistrationRequest) {
        //пустой юзер без managerData
        final var detachedManager = managerToManagerRegistrationRequestMapper.mapManagerRegistrationRequestToManagerEntity(managerRegistrationRequest);

        //получаем роль и сеттим ее в менеджера
        final var roleName = managerRegistrationRequest.getRole();
        detachedManager.setRole(roleRepository.findByRoleName(roleName)
                .orElseThrow(() -> new RuntimeException(String.format("Role not found: roleName = %s", roleName)))
        );

        //получаем данные о позиции из запроса - добавить в ManagerDepartment (как json)
        final var userPosition = managerRegistrationRequest.getData().getPersonalInfo().getPositions().stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Данные о позициях отсутствуют"));

        final var managerData = managerRegistrationDataToManagerDataMapper.mapManagerRegistrationDataToManagerData(
                managerRegistrationRequest.getData()
        );
        detachedManager.setManagerData(managerData);

        final var persistedManager = managerRepository.save(detachedManager);

        //ищем департамент
        final var departmentEntity = departmentRepository.findByDepartmentUuid(UUID.fromString(managerRegistrationRequest.getData().getDepartment()))
                .orElseThrow(() -> new RuntimeException(String.format("Department not found: roleName = %s", managerRegistrationRequest.getData().getDepartment())));

        //новая логика с many-to-many
        final var detachedManagerDepartment = ManagerDepartment.builder()
                .manager(persistedManager)
                .department(departmentEntity)
                .createTimestamp(LocalDateTime.now())
                .updateTimestamp(LocalDateTime.now())
                .build();
        managerDepartmentRepository.save(detachedManagerDepartment);

        return managerToManagerRegistrationRequestMapper.mapManagerEntityToManagerRegistrationResponse(
                persistedManager
        );
    }
}
