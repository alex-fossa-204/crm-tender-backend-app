package com.alexfossa204.crmtenderbackendapp.service.manager.domain.dto;

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
public class ManagerDomainModel {

    @JsonProperty
    private String managerState;

    @JsonProperty
    private UUID managerUuid;

    @JsonProperty
    private String firstname;

    @JsonProperty
    private String lastname;

    @JsonProperty
    private String middlename;

    @JsonProperty
    private Map<String, String> contacts;

    @JsonProperty
    private LocalDateTime registrationTimestamp;

    @JsonProperty
    private LocalDateTime lastLoginTimestamp;

    @JsonProperty
    private LocalDateTime updateTimestamp;

    @JsonProperty
    private String generalInfo;

    @JsonProperty
    private String email;

    @JsonProperty
    private String login;

    //TODO убрать из domain model
    @JsonProperty
    private String password;

    @JsonProperty
    private String role;
    
}
