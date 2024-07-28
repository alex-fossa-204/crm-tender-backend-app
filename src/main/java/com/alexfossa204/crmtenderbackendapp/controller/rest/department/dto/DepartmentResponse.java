package com.alexfossa204.crmtenderbackendapp.controller.rest.department.dto;

import com.alexfossa204.crmtenderbackendapp.model.DepartmentData;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Data
public class DepartmentResponse {

    @JsonProperty
    private UUID departmentUuid;

    @JsonProperty
    private DepartmentData data;

    @JsonProperty
    private LocalDateTime registrationTimestamp;

    @JsonProperty
    private LocalDateTime updateTimestamp;

}
