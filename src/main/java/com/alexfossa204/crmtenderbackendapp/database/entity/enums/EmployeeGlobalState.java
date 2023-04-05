package com.alexfossa204.crmtenderbackendapp.database.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EmployeeGlobalState {

    ДОСТУПЕН("Сотрудник доступен для обработки"),
    УВОЛЕН("Сотрудник уволен");

    private final String description;

}
