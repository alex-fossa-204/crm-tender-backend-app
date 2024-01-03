package com.alexfossa204.crmtenderbackendapp.service.tender.domain.dto;

import com.alexfossa204.crmtenderbackendapp.service.lot.domain.dto.LotDomainModel;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.dto.ManagerDomainModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Data
public class TenderDomainModel {

    @JsonProperty
    private String tenderUuid;

    @JsonProperty
    private String name;

    @JsonProperty
    private String tenderState;

    @JsonProperty
    private String typeValue;

    @JsonProperty
    private LocalDateTime creationTimestamp;

    @JsonProperty
    private LocalDateTime updateTimestamp;

    @JsonProperty
    private LocalDateTime deadlineTimestamp;

    @JsonProperty
    private ManagerDomainModel tenderManager;

    @JsonProperty
    private List<LotDomainModel> lots;

}
