package com.alexfossa204.crmtenderbackendapp.service.manager.domain.mapper;

import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;
import com.alexfossa204.crmtenderbackendapp.database.entity.ManagerDepartment;
import com.alexfossa204.crmtenderbackendapp.model.UserDepartmentData;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.dto.ManagerDomainModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.ArrayList;
import java.util.List;

/**
 * Компонент предназначенный для преобразования dto в entity
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ManagerDepartmentToManagerDomainModelMapper {

    /**
     * Преобразовать тип entity в тип dto
     * @param managerDepartment экземпляр типа для преобразования
     * @return преобразованный экземпляр
     */
    @Mappings(value = {
            @Mapping(target = "managerUuid", source = "managerDepartment.manager.managerUuid"),
            @Mapping(target = "registrationTimestamp", source = "managerDepartment.manager.registrationTimestamp"),
            @Mapping(target = "updateTimestamp", source = "managerDepartment.manager.updateTimestamp"),
            @Mapping(target = "lastLoginTimestamp", source = "managerDepartment.manager.lastLoginTimestamp"),
            @Mapping(target = "role", source = "managerDepartment.manager.role.roleName"),
            @Mapping(target = "managerData", source = "managerDepartment.manager.managerData"),
            @Mapping(target = "department", source = "managerDepartment.department.data"),
    })
    ManagerDomainModel mapManagerEntityToManagerDomainModel(ManagerDepartment managerDepartment);

    //todo дописать логику агрегации данных о регистрации, позиции в департаменте и лидере

}
