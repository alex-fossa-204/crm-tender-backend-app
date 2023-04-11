package com.alexfossa204.crmtenderbackendapp.controller.rest.tender.domain;

import com.alexfossa204.crmtenderbackendapp.service.tender.domain.dto.TenderDomainModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Компонент, предназначенный для обработки HTTP запросов над тендерами
 */
public interface TenderController {

    /**
     * HTTP:GET получить данные обо всех тендерах
     * @return массив объектов
     */
    ResponseEntity<List<TenderDomainModel>> getRequestFindAllTenders();

}
