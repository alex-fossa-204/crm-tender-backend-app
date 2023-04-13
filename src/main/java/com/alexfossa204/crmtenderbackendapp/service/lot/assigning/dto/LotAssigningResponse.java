package com.alexfossa204.crmtenderbackendapp.service.lot.assigning.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Data
public class LotAssigningResponse {

    private String employeeLotState;

    private LocalDateTime employeeLotStartTimestamp;

}
