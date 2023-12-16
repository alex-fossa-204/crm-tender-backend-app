package com.alexfossa204.crmtenderbackendapp.service.tender.domain;

import com.alexfossa204.crmtenderbackendapp.controller.rest.tender.dto.TenderPageResponse;
import com.alexfossa204.crmtenderbackendapp.service.tender.domain.dto.TenderDomainModel;
import org.springframework.data.domain.PageRequest;

/**
 * Компонент, предназначенный для релизации базовых операций над тендерами
 */
public interface TenderDomainService {

    /**
     * Получить страницу данных тендеров
     * @return массив тендеров
     */
    TenderPageResponse selectTenderPage(PageRequest pageRequest);

    /**
     * Сохранить новый тендера
     * @param tender тендер, подлежащий обновлению
     * @return обновленный сотрудник
     */
    TenderDomainModel updateTender(TenderDomainModel tender);

    /**
     * Удалить тендер
     * @param tender тендер, подлежащий удалению
     */
    void deleteTender(TenderDomainModel tender);

}
