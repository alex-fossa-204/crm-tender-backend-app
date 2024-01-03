package com.alexfossa204.crmtenderbackendapp.service.customer.domain;

import com.alexfossa204.crmtenderbackendapp.controller.rest.customer.dto.CustomerPageResponse;
import org.springframework.data.domain.PageRequest;

/**
 * Компонент, предназначенный для релизации базовых операций над заказчиками
 */
public interface CustomerDomainService {

    /**
     * Получить страницу данных заказчиков
     * @param pageRequest метаданные запроса страницы
     * @return сформированный ответ
     */
    CustomerPageResponse selectCustomerPage(PageRequest pageRequest);

}
