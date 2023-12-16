package com.alexfossa204.crmtenderbackendapp.controller.rest.tender.dto;

import com.alexfossa204.crmtenderbackendapp.service.tender.domain.dto.TenderDomainModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor(staticName = "of")
@Data
public class TenderPageResponse {

    private Long total;

    private List<TenderDomainModel> tenders;

}
