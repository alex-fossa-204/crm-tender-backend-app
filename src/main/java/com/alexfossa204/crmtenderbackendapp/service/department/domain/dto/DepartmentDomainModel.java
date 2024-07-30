package com.alexfossa204.crmtenderbackendapp.service.department.domain.dto;

import com.alexfossa204.crmtenderbackendapp.model.DepartmentData;
import com.alexfossa204.crmtenderbackendapp.model.UserData;
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
public class DepartmentDomainModel {

    @JsonProperty
    private UUID departmentUuid;

    @JsonProperty
    private DepartmentData data;

    @JsonProperty
    private LocalDateTime registrationTimestamp;

    @JsonProperty
    private LocalDateTime updateTimestamp;

    @JsonProperty
    private UserData leader;

}
