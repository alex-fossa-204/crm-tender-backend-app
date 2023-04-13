package com.alexfossa204.crmtenderbackendapp.service.lot.assigning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Data
public class LotAssigningRequest {

    @JsonProperty
    private UUID employeeUuid;

    @JsonProperty
    private UUID lotUuid;

    @JsonProperty
    private UUID managerUuid;

}
