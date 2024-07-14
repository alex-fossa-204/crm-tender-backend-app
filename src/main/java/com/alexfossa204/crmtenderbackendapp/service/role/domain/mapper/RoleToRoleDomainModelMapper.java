package com.alexfossa204.crmtenderbackendapp.service.role.domain.mapper;

import com.alexfossa204.crmtenderbackendapp.database.entity.Role;
import com.alexfossa204.crmtenderbackendapp.service.role.domain.dto.RoleDomainModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleToRoleDomainModelMapper {

    @Mappings(value = {
            @Mapping(target = "role", source = "roleName")
    })
    RoleDomainModel mapRoleToRoleDomainModel(Role role);

}
