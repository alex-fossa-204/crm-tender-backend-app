package com.alexfossa204.crmtenderbackendapp.database.entity;

import com.alexfossa204.crmtenderbackendapp.database.entity.employee_lot.EmployeeLot;
import com.alexfossa204.crmtenderbackendapp.database.entity.state.LotGlobalStateType;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
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
@Table(name = "lot")
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    @Type(PostgreSQLEnumType.class)
    private LotGlobalStateType lotState;

    @Column
    private UUID lotUuid;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    private Map<String, String> lotData;

    @Column
    private LocalDateTime lotCreationTimestamp;

    @Column
    private LocalDateTime lotUpdateTimestamp;

    @ManyToOne
    @JoinColumn(name = "tender_id")
    private Tender tender;

    @OneToMany(mappedBy = "lotEmployeeLot", fetch = FetchType.EAGER)
    @Getter
    @Setter
    @Builder.Default
    private List<EmployeeLot> employeeLots = new ArrayList<>();

}
