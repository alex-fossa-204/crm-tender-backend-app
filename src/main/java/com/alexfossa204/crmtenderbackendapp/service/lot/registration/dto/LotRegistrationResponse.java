package com.alexfossa204.crmtenderbackendapp.service.lot.registration.dto;

import com.alexfossa204.crmtenderbackendapp.database.entity.state.LotGlobalStateType;
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
public class LotRegistrationResponse {

    @JsonProperty
    private LotGlobalStateType lotState;

    @JsonProperty
    private UUID lotUuid;

    @JsonProperty
    private LocalDateTime lotCreationTimestamp;

}
