package com.alexfossa204.crmtenderbackendapp.service;

import com.alexfossa204.crmtenderbackendapp.database.entity.Employee;

import java.util.List;

/**
 * Компонент, предназначенный для реализации базовый операций над сотрудниками СРМ
 */
public interface EmployeeService {

    /**
     * Найти всех сотрудников
     * @return массив сотрудников
     */
    List<Employee> findAllEmployees();

    /**
     * Сохранить нового сотрудника
     * @param employee сотрудник, подлежащий сохранению
     * @return сохраненный сотрудник
     */
    Employee saveEmployee(Employee employee);

    /**
     * Сохранить нового сотрудника
     * @param employee сотрудник, подлежащий обновлению
     * @return обновленный сотрудник
     */
    Employee updateEmployee(Employee employee);

    /**
     * Удалить сотрудника
     * @param employee сотрудник, подлежащий удалению
     */
    void deleteEmployee(Employee employee);

}
