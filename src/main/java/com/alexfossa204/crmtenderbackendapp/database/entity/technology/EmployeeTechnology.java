package com.alexfossa204.crmtenderbackendapp.database.entity.technology;

import com.alexfossa204.crmtenderbackendapp.database.entity.Employee;
import com.alexfossa204.crmtenderbackendapp.database.entity.Technology;
import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "employee_technologies")
public class EmployeeTechnology {

    @EmbeddedId
    private EmployeeTechnologyKey id;

    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    private Employee employeeEmployeeTechnology;

    @ManyToOne
    @MapsId("technologyId")
    @JoinColumn(name = "technology_id")
    private Technology technologyEmployeeTechnology;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    @Type(PostgreSQLEnumType.class)
    @Getter
    private TechnologyGradeType technologyGrade;

    @Column
    private LocalDateTime gradeUpdateDate;

}
