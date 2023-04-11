package com.alexfossa204.crmtenderbackendapp.service.manager.registration;

import com.alexfossa204.crmtenderbackendapp.service.manager.registration.dto.ManagerRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.manager.registration.dto.ManagerRegistrationResponse;

/**
 * Компонент, предназначенный для регистрации менеджеров в системе
 */
public interface ManagerRegistrationService {

    /**
     * Зарегистрировать менеджера в системе
     * @param managerRegistrationRequest запрос на регистрацию менеджера
     * @return ответ на запрос о регистрации менеджера
     */
    ManagerRegistrationResponse registerManager(ManagerRegistrationRequest managerRegistrationRequest);

}
