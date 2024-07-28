package com.alexfossa204.crmtenderbackendapp.service.manager.registration.dto;

import com.alexfossa204.crmtenderbackendapp.model.ManagerRegistrationData;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Data
public class ManagerRegistrationRequest {

    @JsonProperty
    private ManagerRegistrationData data;

    @JsonProperty
    private String role;
    
}
