package com.alexfossa204.crmtenderbackendapp.service.manager.domain;

import com.alexfossa204.crmtenderbackendapp.controller.rest.employee.dto.EmployeePageResponse;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.dto.ManagerDomainModel;
import org.springframework.data.domain.PageRequest;

public interface ManagerDomainService {

    /**
     * Найти всех менеджеров
     * @return массив менеджеров
     */
    EmployeePageResponse selectManagerPage(PageRequest pageRequest);

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
