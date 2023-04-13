package com.alexfossa204.crmtenderbackendapp.service.lot.assigning.mapper;

import com.alexfossa204.crmtenderbackendapp.database.entity.employee_lot.EmployeeLot;
import com.alexfossa204.crmtenderbackendapp.service.lot.assigning.dto.LotAssigningResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface LotAssigningMapper {

    @Mappings(value = {
        @Mapping(target = "employeeLotState", source = "employeeLotState"),
        @Mapping(target = "employeeLotStartTimestamp", source = "employeeLotStartTimestamp")
    })
    LotAssigningResponse mapEmployeeLotEntityToLotAssigningResponse(EmployeeLot employeeLot);

}
