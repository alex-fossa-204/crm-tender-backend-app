package com.alexfossa204.crmtenderbackendapp.service.lot.domain.mapper;

import com.alexfossa204.crmtenderbackendapp.controller.rest.lot.dto.LotDomainModel;
import com.alexfossa204.crmtenderbackendapp.database.entity.Lot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LotEntityToLotDomainModelMapper {

    @Mappings(value = {
            @Mapping(target = "lotState", source = "lotState"),
            @Mapping(target = "lotUuid", source = "lotUuid")
    })
    LotDomainModel mapLotEntityToLotDomainModel(Lot lot);

    @Mappings(value = {
            @Mapping(target = "lotState", source = "lotState"),
    })
    Lot mapLotDomainModelToLotEntity(LotDomainModel lotDomainModel);

}
