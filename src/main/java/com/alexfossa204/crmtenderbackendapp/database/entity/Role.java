package com.alexfossa204.crmtenderbackendapp.database.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
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
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Setter
    private UUID id;

    @Column
    @Getter
    @Setter
    private String roleName;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    @Getter
    @Setter
    private Map<String, List<String>> privileges;

    @OneToMany(mappedBy = "role")
    @Setter
    @Builder.Default
    private List<Manager> managers = new ArrayList<>();

}
