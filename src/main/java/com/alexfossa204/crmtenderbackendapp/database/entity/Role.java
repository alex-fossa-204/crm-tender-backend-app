package com.alexfossa204.crmtenderbackendapp.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String roleName;

    @OneToMany(mappedBy = "role")
    @Builder.Default
    private List<Manager> managers = new ArrayList<>();

}
