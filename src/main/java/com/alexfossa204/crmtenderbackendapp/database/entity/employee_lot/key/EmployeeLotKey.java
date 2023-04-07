package com.alexfossa204.crmtenderbackendapp.database.entity.employee_lot.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Data
@Builder
@Embeddable
public class EmployeeLotKey implements Serializable {

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "lot_id")
    private Long lotId;

}
