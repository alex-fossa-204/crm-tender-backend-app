package com.alexfossa204.crmtenderbackendapp.service.employee.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Data
public class EmployeeDomainModel {

    @JsonProperty
    private UUID employeeUuid;

    @JsonProperty
    private String employeeGlobalState;

    @JsonProperty
    private String firstname;

    @JsonProperty
    private String lastname;

    @JsonProperty
    private String middlename;

    @JsonProperty
    private Map<String, String> contacts;

    @JsonProperty
    private String organisationName;

    @JsonProperty
    private Map<String, String> employeeLocation;

    @JsonProperty
    private Double experienceBeforeHiringMonth;

    @JsonProperty
    private LocalDateTime registrationTimestamp;

    @JsonProperty
    private LocalDate hiringDate;

    @JsonProperty
    private LocalDate firingDate;

    @JsonProperty
    private String generalInfo;

    @JsonProperty
    private Map<String, String> employeeDocumentsInfo;

    @JsonProperty
    private Map<String, String> currentProjectInfo;

    @JsonProperty
    private List<EmployeeTechnologyDomain> technologies;

}
