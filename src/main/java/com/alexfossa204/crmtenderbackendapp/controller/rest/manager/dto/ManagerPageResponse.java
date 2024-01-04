package com.alexfossa204.crmtenderbackendapp.controller.rest.manager.dto;

import com.alexfossa204.crmtenderbackendapp.service.manager.domain.dto.ManagerDomainModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor(staticName = "of")
@Data
public class ManagerPageResponse {

    @JsonProperty
    private Long total;

    @JsonProperty
    private List<ManagerDomainModel> managers;

}
