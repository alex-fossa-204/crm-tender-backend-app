package com.alexfossa204.crmtenderbackendapp.database.entity;

import com.alexfossa204.crmtenderbackendapp.database.entity.state.TenderGlobalStateType;
import com.alexfossa204.crmtenderbackendapp.database.entity.state.TenderType;
import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private String tenderUuid;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    @Type(PostgreSQLEnumType.class)
    private TenderGlobalStateType tenderState;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    @Type(PostgreSQLEnumType.class)
    private TenderType typeValue;

    @Column
    private LocalDateTime creationTimestamp;

    @Column
    private LocalDateTime updateTimestamp;

    @Column
    private LocalDateTime deadlineTimestamp;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    //todo сделать генерацию данных их json2pojo схем объект типа TenderData
    @ManyToOne
    @JoinColumn(name = "tender_manager_id")
    private Manager tenderManager;

    @OneToMany(mappedBy = "tender", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true) //TODO сделать выгрузку по графу или субселекту
    @Builder.Default
    private List<Lot> lots = new ArrayList<>();

}
