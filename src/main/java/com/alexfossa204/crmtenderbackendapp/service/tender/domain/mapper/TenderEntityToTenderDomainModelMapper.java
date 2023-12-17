package com.alexfossa204.crmtenderbackendapp.service.tender.domain.mapper;

import com.alexfossa204.crmtenderbackendapp.database.entity.Tender;
import com.alexfossa204.crmtenderbackendapp.service.tender.domain.dto.TenderDomainModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TenderEntityToTenderDomainModelMapper {

    @Mappings(value = {
            @Mapping(target = "tenderState", source = "tenderState"),
            @Mapping(target = "typeValue", source = "typeValue")
    })
    TenderDomainModel mapTenderEntityToTenderDomainModel(Tender tender);

}
