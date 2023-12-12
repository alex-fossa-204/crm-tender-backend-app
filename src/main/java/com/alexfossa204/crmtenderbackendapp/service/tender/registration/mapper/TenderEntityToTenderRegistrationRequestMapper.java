package com.alexfossa204.crmtenderbackendapp.service.tender.registration.mapper;

import com.alexfossa204.crmtenderbackendapp.database.entity.Tender;
import com.alexfossa204.crmtenderbackendapp.service.tender.registration.dto.TenderRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.tender.registration.dto.TenderRegistrationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TenderEntityToTenderRegistrationRequestMapper {

    @Mappings(value = {
            @Mapping(target = "tenderGlobalState", source = "tenderGlobalState"),
            @Mapping(target = "tenderTypeValue", source = "tenderTypeValue"),
            @Mapping(target = "bankGuaranty", source = "bankGuaranty"),
            @Mapping(target = "tenderCreationTimestamp", expression = "java(java.time.LocalDateTime.now())"),
            @Mapping(target = "tenderUpdateTimestamp", expression = "java(java.time.LocalDateTime.now())"),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "customer", ignore = true),
            @Mapping(target = "lots", ignore = true),
            @Mapping(target = "tenderManager", ignore = true)
    })
    Tender mapTenderRegistrationRequestToTenderEntity(TenderRegistrationRequest tenderRegistrationRequest);

    @Mappings(value = {
            @Mapping(target = "tenderGlobalState", source = "tenderGlobalState"),
            @Mapping(target = "tenderTypeValue", source = "tenderTypeValue")
    })
    TenderRegistrationResponse mapTenderEntityToTenderRegistrationResponse(Tender tender);

}
