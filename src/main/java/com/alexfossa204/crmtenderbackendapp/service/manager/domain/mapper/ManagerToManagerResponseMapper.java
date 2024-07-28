package com.alexfossa204.crmtenderbackendapp.service.manager.domain.mapper;

import com.alexfossa204.crmtenderbackendapp.controller.rest.manager.dto.ManagerResponse;
import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;
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
            @Mapping(target = "managerState", source = "managerState"),
            @Mapping(target = "role", source = "role.roleName")
    })
    ManagerResponse mapManagerEntityToManagerResponse(Manager manager);

}
