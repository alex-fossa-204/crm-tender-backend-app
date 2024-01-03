package com.alexfossa204.crmtenderbackendapp.service.customer.domain.mapper;

import com.alexfossa204.crmtenderbackendapp.database.entity.Customer;
import com.alexfossa204.crmtenderbackendapp.service.customer.domain.dto.CustomerDomainModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CustomerToCustomerDomainModelMapper {

    @Mappings(
            @Mapping(target = "name", source = "customerName")
    )
    CustomerDomainModel mapCustomerEntityToCustomerDomainModel(Customer customer);

}
