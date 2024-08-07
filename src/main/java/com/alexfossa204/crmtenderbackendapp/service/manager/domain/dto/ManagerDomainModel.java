package com.alexfossa204.crmtenderbackendapp.service.manager.domain.dto;

import com.alexfossa204.crmtenderbackendapp.model.DepartmentData;
import com.alexfossa204.crmtenderbackendapp.model.ManagerData;
import com.alexfossa204.crmtenderbackendapp.model.UserDepartmentData;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Data
public class ManagerDomainModel {

    @JsonProperty
    private UUID managerUuid;

    @JsonProperty
    private LocalDateTime registrationTimestamp;

    @JsonProperty
    private LocalDateTime updateTimestamp;

    @JsonProperty
    private LocalDateTime lastLoginTimestamp;

    @JsonProperty
    private String role;

    @JsonProperty
    private ManagerData managerData;

    @JsonProperty
    private DepartmentData department; //todo заменить на подробную DTO с данными о лидере, позиции, регистрации в департаменте
    
}
