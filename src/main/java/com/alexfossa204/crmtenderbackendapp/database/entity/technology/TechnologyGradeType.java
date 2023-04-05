package com.alexfossa204.crmtenderbackendapp.database.entity.technology;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TechnologyGradeType {
    J1("Junior 1"),
    J2("Junior 2"),
    J3("Junior 3"),
    M1("Middle 1"),
    M2("Middle 2"),
    M3("Middle 3"),
    S1("Senior 1"),
    S2("Senior 2");

    private final String description;
}
