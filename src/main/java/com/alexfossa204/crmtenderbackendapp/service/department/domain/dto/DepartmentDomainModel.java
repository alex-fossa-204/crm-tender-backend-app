package com.alexfossa204.crmtenderbackendapp.service.department.domain.dto;

import com.alexfossa204.crmtenderbackendapp.model.DepartmentData;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Data
public class DepartmentDomainModel {

    @JsonProperty
    private DepartmentData data;

    @JsonProperty
    private LocalDateTime registrationTimestamp;

    @JsonProperty
    private LocalDateTime updateTimestamp;

}
