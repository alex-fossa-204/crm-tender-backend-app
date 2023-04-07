package com.alexfossa204.crmtenderbackendapp.service.employee.domain;

import com.alexfossa204.crmtenderbackendapp.service.employee.domain.dto.EmployeeDomainModel;

import java.util.List;

/**
 * Компонент, предназначенный для реализации базовый операций над сотрудниками СРМ
 */
public interface EmployeeService {

    /**
     * Найти всех сотрудников
     * @return массив сотрудников
     */
    List<EmployeeDomainModel> findAllEmployees();

    /**
     * Сохранить нового сотрудника
     * @param employeeDomainModel сотрудник, подлежащий сохранению
     * @return сохраненный сотрудник
     */
    EmployeeDomainModel saveEmployee(EmployeeDomainModel employeeDomainModel);

    /**
     * Сохранить нового сотрудника
     * @param employeeDomainModel сотрудник, подлежащий обновлению
     * @return обновленный сотрудник
     */
    EmployeeDomainModel updateEmployee(EmployeeDomainModel employeeDomainModel);

    /**
     * Удалить сотрудника
     * @param employeeDomainModel сотрудник, подлежащий удалению
     */
    void deleteEmployee(EmployeeDomainModel employeeDomainModel);

}
