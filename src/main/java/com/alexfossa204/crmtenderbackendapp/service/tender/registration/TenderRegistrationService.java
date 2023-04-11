package com.alexfossa204.crmtenderbackendapp.service.tender.registration;

import com.alexfossa204.crmtenderbackendapp.service.tender.registration.dto.TenderRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.tender.registration.dto.TenderRegistrationResponse;

/**
 * Компонент, предназначенный для регистрации тендеров в системе
 */
public interface TenderRegistrationService {

    /**
     * Зарегистрировать новый тендер
     * @param tenderRegistrationRequest данные запроса на регистрацию тендера
     * @return
     */
    TenderRegistrationResponse registerNewTender(TenderRegistrationRequest tenderRegistrationRequest);


}
