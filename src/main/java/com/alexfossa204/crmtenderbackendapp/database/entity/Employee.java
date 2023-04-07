package com.alexfossa204.crmtenderbackendapp.database.entity;


import com.alexfossa204.crmtenderbackendapp.database.entity.employee_lot.EmployeeLot;
import com.alexfossa204.crmtenderbackendapp.database.entity.enums.EmployeeGlobalState;

import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.EmployeeTechnology;
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
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private UUID employeeUuid;


    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    @Type(PostgreSQLEnumType.class)
    private EmployeeGlobalState employeeGlobalState;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String middlename;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    private Map<String, String> contacts;

    @Column
    private String organisationName;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    private Map<String, String> employeeLocation;

    @Column
    private Double experienceBeforeHiringMonth;

    @Column
    private LocalDate hiringDate;

    @Column
    private LocalDate firingDate;

    @Column
    private String generalInfo;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    private Map<String, String> employeeDocumentsInfo;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    private Map<String, String> currentProjectInfo;

    @ManyToMany
    @JoinTable(name = "employee_technologies",
            joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "technology_id", referencedColumnName = "id")}
    )
    @Builder.Default
    private List<Technology> technologies = new ArrayList<>();

    @OneToMany(mappedBy = "employeeEmployeeTechnology", fetch = FetchType.EAGER)
    @Builder.Default
    private List<EmployeeTechnology> employeeTechnologies = new ArrayList<>();

    @OneToMany(mappedBy = "employeeEmployeeLot", fetch = FetchType.EAGER)
    @Builder.Default
    private List<EmployeeLot> employeeLots = new ArrayList<>();

}
