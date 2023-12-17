package com.alexfossa204.crmtenderbackendapp.database.entity;

import com.alexfossa204.crmtenderbackendapp.database.entity.state.ManagerStateType;
import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private UUID managerUuid;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    @Type(PostgreSQLEnumType.class)
    private ManagerStateType managerState;

    @Column
    private LocalDateTime registrationTimestamp;

    @Column
    private LocalDateTime updateTimestamp;

    @Column
    private LocalDateTime lastLoginTimestamp;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    //TODO убрать EAGER
    @OneToMany(mappedBy = "tenderManager", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Tender> managerTenders = new ArrayList<>();
}
