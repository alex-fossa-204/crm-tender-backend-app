package com.alexfossa204.crmtenderbackendapp.service.department.domain.mapper;

import com.alexfossa204.crmtenderbackendapp.controller.rest.department.dto.DepartmentResponse;
import com.alexfossa204.crmtenderbackendapp.database.entity.Department;
import com.alexfossa204.crmtenderbackendapp.model.UserData;
import com.alexfossa204.crmtenderbackendapp.model.UserDepartmentData;
import com.alexfossa204.crmtenderbackendapp.service.department.domain.dto.DepartmentDomainModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentToDepartmentDomainModelMapper {

    @Mappings(value = {
            @Mapping(target = "leader", expression = "java(mapDepartmentDataToLeaderData(department))")
    })
    DepartmentDomainModel mapDepartmentToDepartmentDomainModel(Department department);

    DepartmentResponse mapDepartmentToDepartmentResponse(Department department);

    @Mappings(value = {
            @Mapping(target = "leader", expression = "java(mapDepartmentDataToLeaderData(department))"),
            @Mapping(target = "name", source = "department.data.name"),
            @Mapping(target = "shortcut", source = "department.data.shortcut")
    })
    UserDepartmentData mapDepartmentToUserDepartmentData(Department department);

    default UserData mapDepartmentDataToLeaderData(Department department) {
        final var departmentLeaderPersonalInfo = department.getLeader().getManagerData().getPersonalInfo();
        return new UserData.UserDataBuilder()
                .withFirstName(departmentLeaderPersonalInfo.getFirstName())
                .withLastName(departmentLeaderPersonalInfo.getLastName())
                .withMiddleName(departmentLeaderPersonalInfo.getMiddleName())
                .withBirthDate(departmentLeaderPersonalInfo.getBirthDate())
                .withPositions(departmentLeaderPersonalInfo.getPositions())
                .withContacts(departmentLeaderPersonalInfo.getContacts())
                .build();
    }
}
