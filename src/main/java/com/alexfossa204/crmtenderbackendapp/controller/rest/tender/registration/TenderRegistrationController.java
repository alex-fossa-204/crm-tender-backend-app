package com.alexfossa204.crmtenderbackendapp.controller.rest.tender.registration;

import com.alexfossa204.crmtenderbackendapp.service.tender.registration.dto.TenderRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.tender.registration.dto.TenderRegistrationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Компонент, предназначенный для обработки HTTP запросов по регистрации тендеров в системе
 */
public interface TenderRegistrationController {

    /**
     * HTTP:POST запрос на сохранение данных тендера
     * @param tenderRegistrationRequest тело запроса
     * @return тело ответа
     */
    ResponseEntity<TenderRegistrationResponse> postRequestRegisterTender(@RequestBody TenderRegistrationRequest tenderRegistrationRequest);

}
