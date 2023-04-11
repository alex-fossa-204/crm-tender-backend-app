package com.alexfossa204.crmtenderbackendapp.service.manager.registration.dto;

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
public class ManagerRegistrationResponse {

    @JsonProperty
    private UUID managerUuid;

    @JsonProperty
    private String managerState;

    @JsonProperty
    private LocalDateTime registrationTimestamp;
}
