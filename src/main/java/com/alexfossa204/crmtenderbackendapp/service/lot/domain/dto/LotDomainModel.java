package com.alexfossa204.crmtenderbackendapp.service.lot.domain.dto;

import com.alexfossa204.crmtenderbackendapp.service.manager.domain.dto.ManagerDomainModel;
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
public class LotDomainModel {

    @JsonProperty
    private UUID lotUuid;

    @JsonProperty
    private String lotState;

    @JsonProperty
    private String typeValue;

    @JsonProperty
    private String name;

    @JsonProperty
    private LocalDateTime creationTimestamp;

    @JsonProperty
    private LocalDateTime updateTimestamp;

    @JsonProperty
    private LocalDateTime deadlineTimestamp;

    @JsonProperty
    private ManagerDomainModel lotManager;

}
