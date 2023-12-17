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
            @Mapping(target = "tenderState", source = "tenderState"),
            @Mapping(target = "typeValue", source = "typeValue"),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "customer", ignore = true),
            @Mapping(target = "lots", ignore = true),
            @Mapping(target = "tenderManager", ignore = true)
    })
    Tender mapTenderRegistrationRequestToTenderEntity(TenderRegistrationRequest tenderRegistrationRequest);

    @Mappings(value = {
            @Mapping(target = "tenderState", source = "tenderState"),
            @Mapping(target = "typeValue", source = "typeValue")
    })
    TenderRegistrationResponse mapTenderEntityToTenderRegistrationResponse(Tender tender);

}
