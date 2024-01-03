package com.alexfossa204.crmtenderbackendapp.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private UUID customerUuid;

    @Column
    private String customerName;

    @OneToMany(mappedBy = "customer")
    @Builder.Default
    private List<Tender> tenders = new ArrayList<>();

}
