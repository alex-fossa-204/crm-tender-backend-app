package com.alexfossa204.crmtenderbackendapp.controller.rest.manager.registration;

import com.alexfossa204.crmtenderbackendapp.service.manager.registration.dto.ManagerRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.manager.registration.dto.ManagerRegistrationResponse;
import org.springframework.http.ResponseEntity;

/**
 * Компонент, предназначенный для обработки HTTP запросов п орегистрации менеджеров в системе
 */
public interface ManagerRegistrationController {

    /**
     * HTTP: POST запрос на сохранение данных менеджера
     * @param managerRegistrationRequest тело запроса
     * @return тело ответа
     */
    ResponseEntity<ManagerRegistrationResponse> postRequestRegisterManager(ManagerRegistrationRequest managerRegistrationRequest);

}
