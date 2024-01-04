package com.alexfossa204.crmtenderbackendapp.controller.rest.base.dto.delete;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Data
public class BaseDeleteResponse {

    @JsonProperty
    private String uuid;

    @JsonProperty
    private String message;

}
