package com.alexfossa204.crmtenderbackendapp.database.entity;

import com.alexfossa204.crmtenderbackendapp.database.entity.enums.TenderGlobalStateType;
import com.alexfossa204.crmtenderbackendapp.database.entity.enums.TenderType;
import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tender")
public class Tender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column
    @Getter
    private String tenderNumber;

    @Column
    @Getter
    private String tenderName;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    @Type(PostgreSQLEnumType.class)
    @Getter
    private TenderGlobalStateType tenderGlobalState;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    @Type(PostgreSQLEnumType.class)
    @Getter
    private TenderType tenderTypeValue;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    @Getter
    private Map<String, String> tenderDescription;

    @Column
    @Getter
    private LocalDateTime tenderCreationTimestamp;

    @Column
    @Getter
    private LocalDateTime tenderUpdateTimestamp;

    @Column
    @Getter
    private LocalDateTime tenderDeadlineTimestamp;

    @Column
    @Getter
    private Integer tenderBaseLotQuantity;

    @Column
    @Getter
    private Integer tenderFinalLotQuantity;

    @Column
    @Getter
    private BigDecimal tenderNmcCost;

    @Column
    @Getter
    private BigDecimal tenderFinalCost;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    @Getter
    private Map<String, List<String>> organisations;

    @Column
    @Getter
    private boolean isBankGuaranty;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    @Getter
    private Map<String, String> tenderEstimationCriteria;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    @Getter
    private Map<String, String> employeeDocumentRequirements;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @Getter
    @Setter
    private Customer customer;

    @OneToMany(mappedBy = "tender")
    @Builder.Default
    private List<Lot> lots = new ArrayList<>();

}
