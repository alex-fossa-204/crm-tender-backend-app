package com.alexfossa204.crmtenderbackendapp.database.entity;

import com.alexfossa204.crmtenderbackendapp.database.entity.employee_lot.EmployeeLot;
import com.alexfossa204.crmtenderbackendapp.database.entity.state.ManagerStateType;
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
import java.util.List;
import java.util.Map;
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

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    @Type(PostgreSQLEnumType.class)
    private ManagerStateType managerState;

    @Column
    private UUID managerUuid;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String middlename;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    private Map<String, String> contacts;

    @Column
    private LocalDateTime registrationTimestamp;

    @Column
    private LocalDateTime lastLoginTimestamp;

    @Column
    private LocalDateTime updateTimestamp;

    @Column
    private String generalInfo;

    @Column
    private String email;

    @Column
    private String login;

    @Column
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "lotManager", fetch = FetchType.EAGER)
    private List<EmployeeLot> employeeLots;

}
