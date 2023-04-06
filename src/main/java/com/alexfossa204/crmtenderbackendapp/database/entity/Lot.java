package com.alexfossa204.crmtenderbackendapp.database.entity;

import com.alexfossa204.crmtenderbackendapp.database.entity.enums.LotGlobalStateType;
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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "lot")
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    @Type(PostgreSQLEnumType.class)
    @Getter
    @Setter
    private LotGlobalStateType lotState;

    @Column
    @Getter
    @Setter
    private UUID lotUuid;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    @Getter
    @Setter
    private Map<String, String> lotData;

    @Column
    @Getter
    @Setter
    private LocalDateTime lotCreationTimestamp;

    @Column
    @Getter
    @Setter
    private LocalDateTime lotUpdateTimestamp;

    @ManyToOne
    @JoinColumn(name = "tender_id")
    @Getter
    @Setter
    private Tender tender;

}
