package com.alexfossa204.crmtenderbackendapp.database.entity.technology;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
@Setter
@Builder
@Embeddable
public class EmployeeTechnologyKey implements Serializable {

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "technology_id")
    private UUID technologyId;

}
