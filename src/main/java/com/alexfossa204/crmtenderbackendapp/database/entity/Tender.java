package com.alexfossa204.crmtenderbackendapp.database.entity;

import com.alexfossa204.crmtenderbackendapp.database.entity.state.TenderGlobalStateType;
import com.alexfossa204.crmtenderbackendapp.database.entity.state.TenderType;
import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tender")
public class Tender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String tenderNumber;

    @Column
    private String tenderName;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    @Type(PostgreSQLEnumType.class)
    private TenderGlobalStateType tenderGlobalState;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    @Type(PostgreSQLEnumType.class)
    private TenderType tenderTypeValue;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    private Map<String, String> tenderDescription;

    @Column
    private LocalDateTime tenderCreationTimestamp;

    @Column
    private LocalDateTime tenderUpdateTimestamp;

    @Column
    private LocalDateTime tenderDeadlineTimestamp;

    @Column
    private Integer tenderBaseLotQuantity;

    @Column
    private Integer tenderFinalLotQuantity;

    @Column
    private BigDecimal tenderNmcCost;

    @Column
    private BigDecimal tenderFinalCost;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    private Map<String, List<String>> organisations;

    @Column(name = "is_bank_guaranty")
    private boolean bankGuaranty;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    private Map<String, String> tenderEstimationCriteria;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    private Map<String, String> employeeDocumentRequirements;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "tender_manager_id")
    private Manager tenderManager;

    @OneToMany(mappedBy = "tender", fetch = FetchType.EAGER) //TODO сдлеать выгрузку по графу или субселекту
    @Builder.Default
    private List<Lot> lots = new ArrayList<>();

}
