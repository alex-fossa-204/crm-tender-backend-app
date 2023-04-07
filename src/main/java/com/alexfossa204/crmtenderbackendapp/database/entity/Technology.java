package com.alexfossa204.crmtenderbackendapp.database.entity;

import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.EmployeeTechnology;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "technology")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Setter
    private UUID id;

    @Column
    @Getter
    @Setter
    private UUID technologyUuid;

    @Column
    @Getter
    @Setter
    private String technologyName;

    @Column
    @Getter
    @Setter
    private String technologyDescription;

    @Column
    @Getter
    @Setter
    private String department;

    @ManyToMany(mappedBy = "technologies")
    @Builder.Default
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(mappedBy = "technologyEmployeeTechnology")
    @Builder.Default
    private List<EmployeeTechnology> employeeTechnologies = new ArrayList<>();


}
