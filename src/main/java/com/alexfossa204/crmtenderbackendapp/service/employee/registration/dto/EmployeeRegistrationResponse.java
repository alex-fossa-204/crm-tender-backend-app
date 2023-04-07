package com.alexfossa204.crmtenderbackendapp.service.employee.registration.dto;

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
public class EmployeeRegistrationResponse {

    @JsonProperty
    private UUID employeeUuid;

    @JsonProperty
    private String employeeGlobalState;

    @JsonProperty
    private LocalDateTime registrationTimestamp;

}
