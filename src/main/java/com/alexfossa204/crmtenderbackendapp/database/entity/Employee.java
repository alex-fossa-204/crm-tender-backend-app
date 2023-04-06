package com.alexfossa204.crmtenderbackendapp.database.entity;


import com.alexfossa204.crmtenderbackendapp.database.entity.enums.EmployeeGlobalState;

import com.alexfossa204.crmtenderbackendapp.database.entity.technology.EmployeeTechnology;
import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column
    @Getter
    @Setter
    private UUID employeeUuid;


    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    @Type(PostgreSQLEnumType.class)
    @Getter
    @Setter
    private EmployeeGlobalState employeeGlobalState;

    @Column
    @Getter
    @Setter
    private String firstname;

    @Column
    @Getter
    @Setter
    private String lastname;

    @Column
    @Getter
    @Setter
    private String middlename;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    @Getter
    @Setter
    private Map<String, String> contacts;

    @Column
    @Getter
    @Setter
    private String organisationName;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    @Getter
    @Setter
    private Map<String, String> employeeLocation;

    @Column
    @Getter
    @Setter
    private Double experienceBeforeHiringMonth;

    @Column
    @Getter
    @Setter
    private LocalDate hiringDate;

    @Column
    @Getter
    @Setter
    private LocalDate firingDate;

    @Column
    @Getter
    @Setter
    private String generalInfo;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    @Getter
    @Setter
    private Map<String, String> employeeDocumentsInfo;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    @Getter
    @Setter
    private Map<String, String> currentProjectInfo;

    @OneToMany(mappedBy = "employeeEmployeeTechnology", fetch = FetchType.EAGER)
    @Getter
    @Setter
    @Builder.Default
    private List<EmployeeTechnology> employeeTechnologies = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "employee_technologies",
            joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "technology_id", referencedColumnName = "id")}
    )
    @Builder.Default
    private List<Technology> technologies = new ArrayList<>();



}
