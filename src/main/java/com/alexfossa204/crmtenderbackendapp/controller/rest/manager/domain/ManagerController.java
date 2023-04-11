package com.alexfossa204.crmtenderbackendapp.controller.rest.manager.domain;

import com.alexfossa204.crmtenderbackendapp.service.manager.domain.dto.ManagerDomainModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Компонент, предназначенный для обработки HTTP зпросов над менеджерами (пользователями)
 */
public interface ManagerController {

    /**
     * HTTP:GET запрос на получении данных обо всех менеджерах
     * @return массив объектов
     */
    ResponseEntity<List<ManagerDomainModel>> getRequestFindAllManagers();

}
