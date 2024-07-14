package com.alexfossa204.crmtenderbackendapp.service.role.domain;

import com.alexfossa204.crmtenderbackendapp.service.role.domain.dto.RoleDomainModel;

import java.util.List;

public interface RoleDomainService {

    List<RoleDomainModel> findAllRoles();

}
