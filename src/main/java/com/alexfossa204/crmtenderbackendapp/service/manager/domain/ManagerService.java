package com.alexfossa204.crmtenderbackendapp.service.manager.domain;

import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.dto.ManagerDomainModel;

import java.util.List;

public interface ManagerService {

    /**
     * Найти всех менеджеров
     * @return массив менеджеров
     */
    List<ManagerDomainModel> findAllManagers();

    /**
     * Сохранить нового сотрудника
     * @param manager сотрудник, подлежащий обновлению
     * @return обновленный сотрудник
     */
    ManagerDomainModel updateManager(ManagerDomainModel manager);

    /**
     * Удалить сотрудника
     * @param manager сотрудник, подлежащий удалению
     */
    void deleteManager(ManagerDomainModel manager);
    
}
