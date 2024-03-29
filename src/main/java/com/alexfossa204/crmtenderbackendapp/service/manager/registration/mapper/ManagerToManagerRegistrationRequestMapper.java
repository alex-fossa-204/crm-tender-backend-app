package com.alexfossa204.crmtenderbackendapp.service.manager.registration.mapper;

import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;
import com.alexfossa204.crmtenderbackendapp.service.manager.registration.dto.ManagerRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.manager.registration.dto.ManagerRegistrationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

/**
 * Компонент предназначенный для преобразования dto в entity
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ManagerToManagerRegistrationRequestMapper {

    /**
     * Преобразовать тип dto в тип entity
     * @param managerRegistrationRequest экземпляр типа для преобразования
     * @return преобразованный экземпляр
     */
    @Mappings(value = {
            @Mapping(target = "managerState", source = "managerState"),
            @Mapping(target = "managerUuid", expression = "java(java.util.UUID.randomUUID())"),
            @Mapping(target = "registrationTimestamp", expression = "java(java.time.LocalDateTime.now())"),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "role", ignore = true)
    })
    Manager mapManagerRegistrationRequestToManagerEntity(ManagerRegistrationRequest managerRegistrationRequest);

    /**
     * Преобразовать тип entity в тип dto
     * @param manager экземпляр типа для преобразования
     * @return преобразованный экземпляр
     */
    @Mappings(value = {
            @Mapping(target = "managerState", source = "managerState")
    })
    ManagerRegistrationResponse mapManagerEntityToManagerRegistrationResponse(Manager manager);

}
