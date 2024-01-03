package com.alexfossa204.crmtenderbackendapp.service.customer.domain.dto;

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
public class CustomerDomainModel {

    @JsonProperty
    private UUID customerUuid;

    @JsonProperty
    private String name;

}
