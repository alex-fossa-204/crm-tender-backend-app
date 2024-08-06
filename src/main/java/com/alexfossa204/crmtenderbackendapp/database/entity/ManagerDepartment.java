package com.alexfossa204.crmtenderbackendapp.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "manager_department")
@ToString
@EqualsAndHashCode
public class ManagerDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column
    private LocalDateTime createTimestamp;

    @Column
    private LocalDateTime updateTimestamp;


}
