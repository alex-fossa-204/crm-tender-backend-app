package com.alexfossa204.crmtenderbackendapp.service.manager.domain;

import com.alexfossa204.crmtenderbackendapp.controller.rest.base.dto.delete.BaseDeleteResponse;
import com.alexfossa204.crmtenderbackendapp.controller.rest.manager.dto.ManagerPageResponse;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.dto.ManagerDomainModel;
import org.springframework.data.domain.PageRequest;

public interface ManagerDomainService {

    /**
     * Найти всех менеджеров
     * @return массив менеджеров
     */
    ManagerPageResponse selectManagerPage(PageRequest pageRequest);

    /**
     * Сохранить нового сотрудника
     * @param manager сотрудник, подлежащий обновлению
     * @return обновленный сотрудник
     */
    ManagerDomainModel updateManager(ManagerDomainModel manager);

    /**
     * Удалить сотрудника
     * @param managerUuid параметр запроса
     */
    BaseDeleteResponse deleteManager(String managerUuid);
    
}
