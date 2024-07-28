package com.alexfossa204.crmtenderbackendapp.database.entity;

import com.alexfossa204.crmtenderbackendapp.model.DepartmentData;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private UUID departmentUuid;

    @Column(columnDefinition = "jsonb")
    @Type(JsonBinaryType.class)
    private DepartmentData data;

    @Column
    private LocalDateTime registrationTimestamp;

    @Column
    private LocalDateTime updateTimestamp;

}
