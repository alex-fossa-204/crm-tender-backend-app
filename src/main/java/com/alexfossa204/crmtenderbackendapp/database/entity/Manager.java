package com.alexfossa204.crmtenderbackendapp.database.entity;

import com.alexfossa204.crmtenderbackendapp.database.entity.enums.ManagerStateType;
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
import jakarta.persistence.JoinTable;
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
@Table(name = "manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    @Type(PostgreSQLEnumType.class)
    @Getter
    @Setter
    private ManagerStateType managerState;

    @Column
    @Getter
    @Setter
    private UUID managerUuid;

    @Column
    @Getter
    @Setter
    private String firstname;

    @Column
    @Getter
    @Setter
    private String lastname;

    @Column
    @Getter
    @Setter
    private String middlename;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    @Getter
    @Setter
    private Map<String, String> contacts;

    @Column
    @Getter
    @Setter
    private LocalDateTime registrationTimestamp;

    @Column
    @Getter
    @Setter
    private LocalDateTime lastLoginTimestamp;

    @Column
    @Getter
    @Setter
    private LocalDateTime updateTimestamp;

    @Column
    @Getter
    @Setter
    private String generalInfo;

    @Column
    @Getter
    @Setter
    private String email;

    @Column
    @Getter
    @Setter
    private String login;

    @Column
    @Getter
    @Setter
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @Getter
    @Setter
    private Role role;

}
