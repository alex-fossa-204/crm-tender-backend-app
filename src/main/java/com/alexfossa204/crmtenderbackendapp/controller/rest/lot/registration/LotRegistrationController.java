package com.alexfossa204.crmtenderbackendapp.controller.rest.lot.registration;

import com.alexfossa204.crmtenderbackendapp.service.lot.registration.dto.LotRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.lot.registration.dto.LotRegistrationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Компонент, предназначенный для обработки HTTP запросов по регистрации лотов в системе
 */
public interface LotRegistrationController {

    ResponseEntity<LotRegistrationResponse> postRequestRegisterLot(@RequestBody LotRegistrationRequest lotRegistrationRequest);

}
