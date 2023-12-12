package com.alexfossa204.crmtenderbackendapp.service.lot.registration.mapper;

import com.alexfossa204.crmtenderbackendapp.database.entity.Lot;
import com.alexfossa204.crmtenderbackendapp.service.lot.registration.dto.LotRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.lot.registration.dto.LotRegistrationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LotEntityToLotRegistrationRequestMapper {

    @Mappings(value = {
            @Mapping(target = "lotState", source = "lotState"),
            @Mapping(target = "lotUuid", expression = "java(java.util.UUID.randomUUID())"),
            @Mapping(target = "lotCreationTimestamp", expression = "java(java.time.LocalDateTime.now())"),
            @Mapping(target = "id", ignore = true)
    })
    Lot mapLotRegistrationRequestToLotEntity(LotRegistrationRequest lotRegistrationRequest);

    @Mappings(value = {
            @Mapping(target = "lotState", source = "lotState")
    })
    LotRegistrationResponse mapLotEntityToLotRegistrationResponse(Lot lot);

}
