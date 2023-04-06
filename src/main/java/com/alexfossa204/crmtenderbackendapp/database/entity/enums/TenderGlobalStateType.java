package com.alexfossa204.crmtenderbackendapp.database.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TenderGlobalStateType {
    ЗАЯВКА_ПОДАНА("Заявка подана заказчику"),
    АКТИВНЫЙ("Активный"),
    ПРОДЛЕН("Продлен"),
    НЕАКТИВНЫЙ("Неактивный");

    private final String description;
}
