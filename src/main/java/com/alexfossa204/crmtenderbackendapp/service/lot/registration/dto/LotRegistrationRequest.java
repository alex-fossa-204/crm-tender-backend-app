package com.alexfossa204.crmtenderbackendapp.service.lot.registration.dto;

import com.alexfossa204.crmtenderbackendapp.database.entity.state.LotGlobalStateType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Data
public class LotRegistrationRequest {

    @JsonProperty
    private String lotState;

    @JsonProperty
    private String lotName;

    @JsonProperty
    private Map<String, String> lotData;

    @JsonProperty
    private String tenderNumber;

}
