package com.alexfossa204.crmtenderbackendapp.service.lot.domain;

import com.alexfossa204.crmtenderbackendapp.controller.rest.base.dto.delete.BaseDeleteResponse;
import com.alexfossa204.crmtenderbackendapp.service.lot.domain.dto.LotDomainModel;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Компонент, предназначенный для релизации базовых операций над лотами
 */
public interface LotDomainService {

    /**
     * Найти все лоты
     * @return массив лоты
     */
    List<LotDomainModel> findAllLots(PageRequest pageRequest);

    /**
     * Сохранить нового лота
     * @param lot лот, подлежащий сохранению
     * @return сохраненный лот
     */
    LotDomainModel saveLot(LotDomainModel lot);

    /**
     * Сохранить нового лота
     * @param lot лот, подлежащий обновлению
     * @return обновленный лот
     */
    LotDomainModel updateLot(LotDomainModel lot);

    /**
     * Удалить лота
     * @param lotUuid лот, подлежащий удалению
     */
    BaseDeleteResponse deleteLot(String lotUuid);

}
