package com.alexfossa204.crmtenderbackendapp.controller.rest.department.dto;

import com.alexfossa204.crmtenderbackendapp.service.department.domain.dto.DepartmentDomainModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor(staticName = "of")
@Data
public class DepartmentPageResponse {

    @JsonProperty
    private Long total;

    @JsonProperty
    private List<DepartmentDomainModel> departments;


}
