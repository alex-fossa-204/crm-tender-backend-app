package com.alexfossa204.crmtenderbackendapp.database.entity.state;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TenderType {

    ПОДАЧА_КП("Подача коммерческого предложения"),
    АУКЦИОН("Участвует в аукционе"),
    АУКЦОН_ПОСЛЕ_ДОПУСКА("Участвует в аукционе после допуска"),
    АНАЛИЗ_РЫНКА("Анализ Рынка");

    private final String description;

}
