package com.alexfossa204.crmtenderbackendapp.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
