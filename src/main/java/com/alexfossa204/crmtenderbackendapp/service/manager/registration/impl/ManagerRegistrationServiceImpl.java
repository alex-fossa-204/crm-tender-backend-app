package com.alexfossa204.crmtenderbackendapp.service.manager.registration.impl;

import com.alexfossa204.crmtenderbackendapp.database.repository.DepartmentRepository;
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

    @Override
    public ManagerRegistrationResponse registerManager(ManagerRegistrationRequest managerRegistrationRequest) {
        //пустой юзер без managerData
        final var detachedManager = managerToManagerRegistrationRequestMapper.mapManagerRegistrationRequestToManagerEntity(managerRegistrationRequest);

        //получаем роль и сеттим ее в менеджера
        final var roleName = managerRegistrationRequest.getRole();
        detachedManager.setRole(roleRepository.findByRoleName(roleName)
                .orElseThrow(() -> new RuntimeException(String.format("Role not found: roleName = %s", roleName)))
        );

        //ищем департамент
        final var departmentEntity = departmentRepository.findByDepartmentUuid(UUID.fromString(managerRegistrationRequest.getData().getDepartment()))
                        .orElseThrow(() -> new RuntimeException(String.format("Department not found: roleName = %s", managerRegistrationRequest.getData().getDepartment())));
        //маппим департамент в json (доработать - переделать на связь в таблице)
        final var userDepartmentData = departmentToDepartmentDomainModelMapper.mapDepartmentToUserDepartmentData(
                departmentEntity
        );
        //получаем данные о позиции из запроса - переделать на реляционную модель
        final var userPosition = managerRegistrationRequest.getData().getPersonalInfo().getPositions().stream().findFirst()
                .orElseThrow(() -> new RuntimeException("Данные о позициях отсутствуют"));
        userDepartmentData.setPosition(userPosition);


        final var managerData = managerRegistrationDataToManagerDataMapper.mapManagerRegistrationDataToManagerData(
                managerRegistrationRequest.getData()
        );
        managerData.setDepartment(userDepartmentData);
        detachedManager.setManagerData(managerData);

        return managerToManagerRegistrationRequestMapper.mapManagerEntityToManagerRegistrationResponse(
                managerRepository.save(detachedManager)
        );
    }
}
