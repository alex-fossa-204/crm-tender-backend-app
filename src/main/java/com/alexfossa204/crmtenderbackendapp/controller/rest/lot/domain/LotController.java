package com.alexfossa204.crmtenderbackendapp.controller.rest.lot.domain;

import com.alexfossa204.crmtenderbackendapp.service.lot.domain.dto.LotDomainModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Контроллер, предназначенный для обработки HTTP запросов над лотами
 */
public interface LotController {

    /**
     * HTTP:GET запрос на получение данных обо всех лотах
     *
     * @return массив объектов
     */
    ResponseEntity<List<LotDomainModel>> getRequestFindAllLots(@RequestParam Integer pageNumber, @RequestParam Integer elementQuantity);

}
