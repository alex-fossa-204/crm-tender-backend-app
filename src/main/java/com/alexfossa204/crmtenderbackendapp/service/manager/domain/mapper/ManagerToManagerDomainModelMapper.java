package com.alexfossa204.crmtenderbackendapp.service.manager.domain.mapper;

import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.dto.ManagerDomainModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

/**
 * Компонент предназначенный для преобразования dto в entity
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ManagerToManagerDomainModelMapper {

    /**
     * Преобразовать тип entity в тип dto
     * @param manager экземпляр типа для преобразования
     * @return преобразованный экземпляр
     */
    @Mappings(value = {
            @Mapping(target = "managerState", source = "managerState"),
            @Mapping(target = "role", source = "role.roleName")
    })
    ManagerDomainModel mapManagerEntityToManagerDomainModel(Manager manager);

    /**
     * Преобразовать тип dto в тип entity
     * @param managerDomainModel экземпляр типа для преобразования
     * @return преобразованный экземпляр
     */
    @Mappings(value = {
            @Mapping(target = "managerState", source = "managerState"),
            @Mapping(target = "role", ignore = true)
    })
    Manager mapManagerDomainModelToManagerEntity(ManagerDomainModel managerDomainModel);

}
