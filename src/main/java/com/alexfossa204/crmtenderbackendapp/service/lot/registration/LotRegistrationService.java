package com.alexfossa204.crmtenderbackendapp.service.lot.registration;

import com.alexfossa204.crmtenderbackendapp.service.lot.registration.dto.LotRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.lot.registration.dto.LotRegistrationResponse;

/**
 * Компонент, предназначенный для регистрации лотов в системе
 */
public interface LotRegistrationService {

    /**
     * Зарегистрировать лот в системе
     * @param lotRegistrationRequest запрос на регистрацию лотаы
     * @return ответ на запрос о регистрации лота
     */
    LotRegistrationResponse registerNewLot(LotRegistrationRequest lotRegistrationRequest);

}
