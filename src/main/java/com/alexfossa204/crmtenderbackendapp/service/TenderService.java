package com.alexfossa204.crmtenderbackendapp.service;

import com.alexfossa204.crmtenderbackendapp.database.entity.Tender;

import java.util.List;

/**
 * Компонент, предназначенный для релизации базовых операций над тендерами
 */
public interface TenderService {

    /**
     * Найти все тендеры
     * @return массив тендеров
     */
    List<Tender> findAllTenders();

    /**
     * Сохранить новый тендер
     * @param tender тендер, подлежащий сохранению
     * @return сохраненный сотрудник
     */
    Tender saveTender(Tender tender);

    /**
     * Сохранить новый тендера
     * @param tender тендер, подлежащий обновлению
     * @return обновленный сотрудник
     */
    Tender updateTender(Tender tender);

    /**
     * Удалить тендер
     * @param tender тендер, подлежащий удалению
     */
    void deleteTender(Tender tender);

}
