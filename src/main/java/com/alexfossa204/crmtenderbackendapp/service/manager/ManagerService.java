package com.alexfossa204.crmtenderbackendapp.service.manager;

import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;

import java.util.List;

public interface ManagerService {

    /**
     * Найти всех менеджеров
     * @return массив менеджеров
     */
    List<Manager> findAllManagers();

    /**
     * Сохранить нового сотрудника
     * @param manager сотрудник, подлежащий сохранению
     * @return сохраненный сотрудник
     */
    Manager saveManager(Manager manager);

    /**
     * Сохранить нового сотрудника
     * @param manager сотрудник, подлежащий обновлению
     * @return обновленный сотрудник
     */
    Manager updateManager(Manager manager);

    /**
     * Удалить сотрудника
     * @param manager сотрудник, подлежащий удалению
     */
    void deleteManager(Manager manager);
    
}
