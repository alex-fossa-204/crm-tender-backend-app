package com.alexfossa204.crmtenderbackendapp.service.lot.domain.mapper;

import com.alexfossa204.crmtenderbackendapp.service.lot.domain.dto.LotDomainModel;
import com.alexfossa204.crmtenderbackendapp.database.entity.Lot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LotToLotDomainModelMapper {

    @Mappings(value = {
            @Mapping(target = "lotState", source = "lotState"),
            @Mapping(target = "lotUuid", source = "lotUuid"),
            //todo проработать маппинг метод с энтити тендеров
//            @Mapping(target = "lotManager.role", source = "lotManager.role.roleName")
    })
    LotDomainModel mapLotEntityToLotDomainModel(Lot lot);

}
