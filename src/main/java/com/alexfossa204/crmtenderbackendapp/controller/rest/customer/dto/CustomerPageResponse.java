package com.alexfossa204.crmtenderbackendapp.controller.rest.customer.dto;

import com.alexfossa204.crmtenderbackendapp.service.customer.domain.dto.CustomerDomainModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor(staticName = "of")
@Data
public class CustomerPageResponse {

    private Long total;

    private List<CustomerDomainModel> customers;

}
