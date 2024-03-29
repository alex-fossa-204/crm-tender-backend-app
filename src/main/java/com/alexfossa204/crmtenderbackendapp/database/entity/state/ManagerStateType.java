package com.alexfossa204.crmtenderbackendapp.database.entity.state;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ManagerStateType {
    АКТИВНЫЙ("Активный пользователь системы"),
    ЗАБЛОКИРОВАННЫЙ("Заблокированный пользователь системы");

    private final String description;
}
