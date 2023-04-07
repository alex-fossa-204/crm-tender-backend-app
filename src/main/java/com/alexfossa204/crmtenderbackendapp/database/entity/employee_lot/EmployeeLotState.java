package com.alexfossa204.crmtenderbackendapp.database.entity.employee_lot;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EmployeeLotState {

    АКТИВНЫЙ("Активный лот в котором участвует сотрудник"),
    ПРОИГРАЛ("Проигранный лот в котором участвовал сотрудник"),
    ПОБЕДИЛ("Победивший лот в котором участвовал сотрудник"),
    ЗАКРЫТ("Лот закрыт");

    private final String description;

}
