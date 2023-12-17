package com.alexfossa204.crmtenderbackendapp.service.tender.registration.dto;

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
public class TenderRegistrationResponse {

    @JsonProperty
    private String tenderState;

    @JsonProperty
    private String typeValue;

    @JsonProperty
    private LocalDateTime creationTimestamp;

}
