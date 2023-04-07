package com.alexfossa204.crmtenderbackendapp.database.entity.employee_lot;

import com.alexfossa204.crmtenderbackendapp.database.entity.Employee;
import com.alexfossa204.crmtenderbackendapp.database.entity.Lot;
import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_lot.key.EmployeeLotKey;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_lot.state.EmployeeLotState;
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
@Builder
@Getter
@Setter
@Entity
@Table(name = "employee_lots")
public class EmployeeLot {

    @EmbeddedId
    private EmployeeLotKey id;

    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    private Employee employeeEmployeeLot;

    @ManyToOne
    @MapsId("lotId")
    @JoinColumn(name = "lot_id")
    private Lot lotEmployeeLot;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager lotManager;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    @Type(PostgreSQLEnumType.class)
    private EmployeeLotState employeeLotState;

    @Column
    private LocalDateTime employeeLotStartTimestamp;

    @Column
    private LocalDateTime employeeLotUpdateTimestamp;

}
