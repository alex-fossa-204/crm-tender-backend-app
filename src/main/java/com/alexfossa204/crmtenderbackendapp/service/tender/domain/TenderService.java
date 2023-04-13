package com.alexfossa204.crmtenderbackendapp.service.tender.domain;

import com.alexfossa204.crmtenderbackendapp.service.tender.domain.dto.TenderDomainModel;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Компонент, предназначенный для релизации базовых операций над тендерами
 */
public interface TenderService {

    /**
     * Найти все тендеры
     * @return массив тендеров
     */
    List<TenderDomainModel> findAllTenders(PageRequest pageRequest);

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
