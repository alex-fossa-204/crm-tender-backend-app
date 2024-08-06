package com.alexfossa204.crmtenderbackendapp.database.entity;

import com.alexfossa204.crmtenderbackendapp.model.ManagerData;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "manager")
@ToString(exclude = {"managerDepartments"})
@EqualsAndHashCode(exclude = {"managerDepartments", "leadingDepartments"})
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private UUID managerUuid;

    @Column
    private LocalDateTime registrationTimestamp;

    @Column
    private LocalDateTime updateTimestamp;

    @Column
    private LocalDateTime lastLoginTimestamp;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(columnDefinition = "jsonb")
    @Type(JsonBinaryType.class)
    private ManagerData managerData;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "manager_department",
            joinColumns = {
                    @JoinColumn(name = "manager_id")
            },
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    @Builder.Default
    private Set<Department> managerDepartments = new HashSet<>();

    @OneToMany(mappedBy = "leader")
    @Builder.Default
    private List<Department> leadingDepartments = new ArrayList<>();

    @OneToMany(mappedBy = "manager")
    @Builder.Default
    private Set<ManagerDepartment> managerDepartmentEntities = new HashSet<>();

}
