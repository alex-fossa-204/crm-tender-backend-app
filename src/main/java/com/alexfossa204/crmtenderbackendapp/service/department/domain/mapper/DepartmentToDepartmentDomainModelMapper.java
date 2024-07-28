package com.alexfossa204.crmtenderbackendapp.service.department.domain.mapper;

import com.alexfossa204.crmtenderbackendapp.controller.rest.department.dto.DepartmentResponse;
import com.alexfossa204.crmtenderbackendapp.database.entity.Department;
import com.alexfossa204.crmtenderbackendapp.model.DepartmentData;
import com.alexfossa204.crmtenderbackendapp.model.UserDepartmentData;
import com.alexfossa204.crmtenderbackendapp.service.department.domain.dto.DepartmentDomainModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentToDepartmentDomainModelMapper {

    DepartmentDomainModel mapDepartmentToDepartmentDomainModel(Department department);

    DepartmentResponse mapDepartmentToDepartmentResponse(Department department);

    UserDepartmentData mapDepartmentToUserDepartmentData(DepartmentData departmentData);

}
