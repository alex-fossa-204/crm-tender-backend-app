package com.alexfossa204.crmtenderbackendapp.service.role.domain.impl;

import com.alexfossa204.crmtenderbackendapp.database.repository.RoleRepository;
import com.alexfossa204.crmtenderbackendapp.service.role.domain.RoleDomainService;
import com.alexfossa204.crmtenderbackendapp.service.role.domain.dto.RoleDomainModel;
import com.alexfossa204.crmtenderbackendapp.service.role.domain.mapper.RoleToRoleDomainModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoleDomainServiceImpl implements RoleDomainService {

    private final RoleToRoleDomainModelMapper roleToRoleDomainModelMapper;

    private final RoleRepository roleRepository;

    @Override
    public List<RoleDomainModel> findAllRoles() {
        return roleRepository.findAll().stream()
                .map(roleToRoleDomainModelMapper::mapRoleToRoleDomainModel)
                .collect(Collectors.toList());
    }
}
