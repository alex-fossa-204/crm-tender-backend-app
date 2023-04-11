package com.alexfossa204.crmtenderbackendapp.service.tender.domain;

import com.alexfossa204.crmtenderbackendapp.database.entity.Tender;
import com.alexfossa204.crmtenderbackendapp.service.tender.domain.dto.TenderDomainModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TenderEntityToTenderDomainModelMapper {

    @Mappings(value = {
            @Mapping(target = "tenderGlobalState", source = "tenderGlobalState"),
            @Mapping(target = "tenderTypeValue", source = "tenderTypeValue"),
            @Mapping(target = "bankGuaranty", source = "bankGuaranty")
    })
    TenderDomainModel mapTenderEntityToTenderDomainModel(Tender tender);

}
