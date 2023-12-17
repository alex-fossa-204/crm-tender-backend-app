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
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column
    @Getter
    @Setter
    private UUID customerUuid;

    @Column
    @Getter
    @Setter
    private String customerName;

    @Column
    @Getter
    @Setter
    private String customerGeneralInfo;

    @OneToMany(mappedBy = "customer")
    @Setter
    @Builder.Default
    private List<Tender> tenders = new ArrayList<>();

}
