package com.alexfossa204.crmtenderbackendapp.service.lot;

import com.alexfossa204.crmtenderbackendapp.database.entity.Lot;

import java.util.List;

/**
 * Компонент, предназначенный для релизации базовых операций над лотами
 */
public interface LotService {

    /**
     * Найти все лоты
     * @return массив лоты
     */
    List<Lot> findAllLots();

    /**
     * Сохранить нового лота
     * @param lot лот, подлежащий сохранению
     * @return сохраненный лот
     */
    Lot saveLot(Lot lot);

    /**
     * Сохранить нового лота
     * @param lot лот, подлежащий обновлению
     * @return обновленный лот
     */
    Lot updateLot(Lot lot);

    /**
     * Удалить лота
     * @param lot лот, подлежащий удалению
     */
    void deleteLot(Lot lot);

}
