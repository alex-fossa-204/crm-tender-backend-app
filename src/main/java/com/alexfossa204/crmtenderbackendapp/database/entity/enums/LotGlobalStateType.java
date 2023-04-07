package com.alexfossa204.crmtenderbackendapp.database.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LotGlobalStateType {

    ЗАЯВКА_ПОДАНА_ЗАКАЗЧИКУ("Заявка на лот подана заказчику"),
    АКТИВНЫЙ("Активный лот"),
    ПРОДЛЕН("Лот продлен"),
    ПОБЕДА("Лот победил"),
    ПРОИГРАН("Лот проиграл"),
    ЗАКРЫТ("Лот закрыт");

    private final String description;

}
