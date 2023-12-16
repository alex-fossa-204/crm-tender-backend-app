package com.alexfossa204.crmtenderbackendapp.service.tender.domain.dto;

import com.alexfossa204.crmtenderbackendapp.service.lot.domain.dto.LotDomainModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Data
public class TenderDomainModel {

    @JsonProperty
    private String tenderNumber;

    @JsonProperty
    private String tenderName;

    @JsonProperty
    private String tenderGlobalState;

    @JsonProperty
    private String tenderTypeValue;

    @JsonProperty
    private Map<String, String> tenderDescription;

    @JsonProperty
    private LocalDateTime tenderCreationTimestamp;

    @JsonProperty
    private LocalDateTime tenderUpdateTimestamp;

    @JsonProperty
    private LocalDateTime tenderDeadlineTimestamp;

    @JsonProperty
    private Integer tenderBaseLotQuantity;

    @JsonProperty
    private Integer tenderFinalLotQuantity;

    @JsonProperty
    private BigDecimal tenderNmcCost;

    @JsonProperty
    private BigDecimal tenderFinalCost;

    @JsonProperty
    private Map<String, List<String>> organisations;

    @JsonProperty
    private boolean bankGuaranty;

    @JsonProperty
    private Map<String, String> tenderEstimationCriteria;

    @JsonProperty
    private Map<String, String> employeeDocumentRequirements;

    @JsonProperty
    private List<LotDomainModel> lots;

}
