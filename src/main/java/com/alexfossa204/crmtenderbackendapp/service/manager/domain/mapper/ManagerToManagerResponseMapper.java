package com.alexfossa204.crmtenderbackendapp.service.manager.domain.mapper;

import com.alexfossa204.crmtenderbackendapp.controller.rest.manager.dto.ManagerResponse;
import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;
import com.alexfossa204.crmtenderbackendapp.database.entity.ManagerDepartment;
import com.alexfossa204.crmtenderbackendapp.model.UserData;
import com.alexfossa204.crmtenderbackendapp.model.UserDepartmentData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

/**
 * Компонент предназначенный для преобразования dto в entity
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ManagerToManagerResponseMapper {

    /**
     * Преобразовать тип entity в тип dto
     * @param manager экземпляр типа для преобразования
     * @return преобразованный экземпляр
     */
    @Mappings(value = {
            @Mapping(target = "managerUuid", source = "managerDepartment.manager.managerUuid"),
            @Mapping(target = "registrationTimestamp", source = "managerDepartment.manager.registrationTimestamp"),
            @Mapping(target = "updateTimestamp", source = "managerDepartment.manager.updateTimestamp"),
            @Mapping(target = "lastLoginTimestamp", source = "managerDepartment.manager.lastLoginTimestamp"),
            @Mapping(target = "role", source = "managerDepartment.manager.role.roleName"),
            @Mapping(target = "managerData", source = "managerDepartment.manager.managerData"),
            @Mapping(target = "department", expression = "java(supplyUserDepartmentData(managerDepartment))")
    })
    ManagerResponse mapManagerEntityToManagerResponse(ManagerDepartment managerDepartment);

    //todo вынести в отдельный метод
    default UserDepartmentData supplyUserDepartmentData(ManagerDepartment managerDepartment) {
        return new UserDepartmentData.UserDepartmentDataBuilder()
                .withName(managerDepartment.getDepartment().getData().getName())
                .withShortcut(managerDepartment.getDepartment().getData().getShortcut())
                .withPosition(managerDepartment.getPositionData())
                .withRegistrationDate(managerDepartment.getCreateTimestamp().toString())
                .withCompanyName(managerDepartment.getDepartment().getData().getCompanyName())
                .withLeader(new UserData.UserDataBuilder()
                        .withFirstName(managerDepartment.getDepartment().getLeader().getManagerData().getPersonalInfo().getFirstName())
                        .withLastName(managerDepartment.getDepartment().getLeader().getManagerData().getPersonalInfo().getLastName())
                        .withMiddleName(managerDepartment.getDepartment().getLeader().getManagerData().getPersonalInfo().getMiddleName())
                        .withBirthDate(managerDepartment.getDepartment().getLeader().getManagerData().getPersonalInfo().getBirthDate())
                        .withContacts(managerDepartment.getDepartment().getLeader().getManagerData().getPersonalInfo().getContacts())
                        .withPositions(managerDepartment.getDepartment().getLeader().getManagerData().getPersonalInfo().getPositions())
                        .build())
                .build();
    }

}
