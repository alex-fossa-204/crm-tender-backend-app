package com.alexfossa204.crmtenderbackendapp.service.tender.domain.mapper;

import com.alexfossa204.crmtenderbackendapp.database.entity.Tender;
import com.alexfossa204.crmtenderbackendapp.service.lot.domain.mapper.LotToLotDomainModelMapper;
import com.alexfossa204.crmtenderbackendapp.service.tender.domain.dto.TenderDomainModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", imports = LotToLotDomainModelMapper.class)
public interface TenderToTenderDomainModelMapper {

    @Mappings(value = {
            @Mapping(target = "tenderState", source = "tenderState"),
            @Mapping(target = "typeValue", source = "typeValue"),
            @Mapping(target = "tenderManager.role", source = "tenderManager.role.roleName"),
    })
    TenderDomainModel mapTenderEntityToTenderDomainModel(Tender tender);

}
