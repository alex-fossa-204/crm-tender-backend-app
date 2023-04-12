package com.alexfossa204.crmtenderbackendapp.service.lot.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Data
public class LotDomainModel {

    @JsonProperty
    private String lotState;

    @JsonProperty
    private String lotName;

    @JsonProperty
    private UUID lotUuid;

    @JsonProperty
    private Map<String, String> lotData;

    @JsonProperty
    private LocalDateTime lotCreationTimestamp;

    @JsonProperty
    private LocalDateTime lotUpdateTimestamp;

}
