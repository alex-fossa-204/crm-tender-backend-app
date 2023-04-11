package com.alexfossa204.crmtenderbackendapp.service.manager.registration.impl;

import com.alexfossa204.crmtenderbackendapp.database.repository.ManagerRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.RoleRepository;
import com.alexfossa204.crmtenderbackendapp.service.manager.registration.ManagerRegistrationService;
import com.alexfossa204.crmtenderbackendapp.service.manager.registration.dto.ManagerRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.manager.registration.dto.ManagerRegistrationResponse;
import com.alexfossa204.crmtenderbackendapp.service.manager.registration.mapper.ManagerToManagerRegistrationRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ManagerRegistrationServiceImpl implements ManagerRegistrationService {

    private final ManagerToManagerRegistrationRequestMapper managerToManagerRegistrationRequestMapper;

    private final ManagerRepository managerRepository;

    private final RoleRepository roleRepository;

    @Override
    public ManagerRegistrationResponse registerManager(ManagerRegistrationRequest managerRegistrationRequest) {
        var detachedManager = managerToManagerRegistrationRequestMapper.mapManagerRegistrationRequestToManagerEntity(managerRegistrationRequest);
        var roleName = managerRegistrationRequest.getRole();

        detachedManager.setRole(roleRepository.findByRoleName(roleName)
                .orElseThrow(() -> new RuntimeException(String.format("Role not found: roleName = %s", roleName)))
        );

        var persistedManager = managerRepository.save(detachedManager);

        return managerToManagerRegistrationRequestMapper.mapManagerEntityToManagerRegistrationResponse(persistedManager);
    }
}
