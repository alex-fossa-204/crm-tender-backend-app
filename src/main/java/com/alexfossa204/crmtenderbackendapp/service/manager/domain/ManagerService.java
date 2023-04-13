package com.alexfossa204.crmtenderbackendapp.service.manager.domain;

import com.alexfossa204.crmtenderbackendapp.service.manager.domain.dto.ManagerDomainModel;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ManagerService {

    /**
     * Найти всех менеджеров
     * @return массив менеджеров
     */
    List<ManagerDomainModel> findAllManagers(PageRequest pageRequest);

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
