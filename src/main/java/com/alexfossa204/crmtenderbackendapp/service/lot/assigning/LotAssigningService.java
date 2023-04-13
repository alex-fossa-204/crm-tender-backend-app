package com.alexfossa204.crmtenderbackendapp.service.lot.assigning;

import com.alexfossa204.crmtenderbackendapp.service.lot.assigning.dto.LotAssigningRequest;
import com.alexfossa204.crmtenderbackendapp.service.lot.assigning.dto.LotAssigningResponse;

/**
 * Компонент, предназначенный для назначения лотов сотрудникам
 */
public interface LotAssigningService {


    /**
     * Назначить лот сотруднику, указать менеджера, ответственного за лот
     * @param lotAssigningRequest объект запроса
     * @return объект ответа
     */
    LotAssigningResponse assignLotToEmployee(LotAssigningRequest lotAssigningRequest);

}
