package com.alexfossa204.crmtenderbackendapp.service.employee.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Data
public class EmployeeTechnologyDomain {

    @JsonProperty
    private String technologyName;

    @JsonProperty
    private String technologyGrade;

}
