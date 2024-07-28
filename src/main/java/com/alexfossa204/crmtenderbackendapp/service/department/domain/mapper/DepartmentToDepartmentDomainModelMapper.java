package com.alexfossa204.crmtenderbackendapp.service.department.domain.mapper;

import com.alexfossa204.crmtenderbackendapp.database.entity.Department;
import com.alexfossa204.crmtenderbackendapp.service.department.domain.dto.DepartmentDomainModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentToDepartmentDomainModelMapper {

    DepartmentDomainModel mapDepartmentToDepartmentDomainModel(Department department);

}
