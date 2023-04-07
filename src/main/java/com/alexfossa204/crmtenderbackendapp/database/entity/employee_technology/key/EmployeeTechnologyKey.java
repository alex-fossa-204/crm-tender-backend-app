package com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Data
@Builder
@Embeddable
public class EmployeeTechnologyKey implements Serializable {

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "technology_id")
    private UUID technologyId;

}
