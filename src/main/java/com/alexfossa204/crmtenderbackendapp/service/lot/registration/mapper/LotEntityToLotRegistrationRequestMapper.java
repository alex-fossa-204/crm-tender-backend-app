package com.alexfossa204.crmtenderbackendapp.service.lot.registration.mapper;

import com.alexfossa204.crmtenderbackendapp.database.entity.Lot;
import com.alexfossa204.crmtenderbackendapp.service.lot.registration.dto.LotRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.lot.registration.dto.LotRegistrationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import static com.alexfossa204.crmtenderbackendapp.config.mapstruct.MapstructConfig.GENERATE_LOCAL_DATE_TIME_EXPRESSION;
import static com.alexfossa204.crmtenderbackendapp.config.mapstruct.MapstructConfig.GENERATE_UUID_EXPRESSION;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LotEntityToLotRegistrationRequestMapper {

    @Mappings(value = {
            @Mapping(target = "lotState", source = "lotState"),
            @Mapping(target = "lotUuid", expression = GENERATE_UUID_EXPRESSION),
            @Mapping(target = "lotCreationTimestamp", expression = GENERATE_LOCAL_DATE_TIME_EXPRESSION),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "employeeLots", ignore = true)
    })
    Lot mapLotRegistrationRequestToLotEntity(LotRegistrationRequest lotRegistrationRequest);

    @Mappings(value = {
            @Mapping(target = "lotState", source = "lotState")
    })
    LotRegistrationResponse mapLotEntityToLotRegistrationResponse(Lot lot);

}
