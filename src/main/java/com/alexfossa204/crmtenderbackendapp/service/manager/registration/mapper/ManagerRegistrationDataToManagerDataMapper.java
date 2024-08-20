package com.alexfossa204.crmtenderbackendapp.service.manager.registration.mapper;

import com.alexfossa204.crmtenderbackendapp.model.ManagerData;
import com.alexfossa204.crmtenderbackendapp.model.ManagerRegistrationData;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ManagerRegistrationDataToManagerDataMapper {

    @Mappings(value = {})
    ManagerData mapManagerRegistrationDataToManagerData(ManagerRegistrationData managerRegistrationData);

}
