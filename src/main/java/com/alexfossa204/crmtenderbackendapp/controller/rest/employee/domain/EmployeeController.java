package com.alexfossa204.crmtenderbackendapp.controller.rest.employee.domain;

import com.alexfossa204.crmtenderbackendapp.service.employee.domain.dto.EmployeeDomainModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Контроллер, предназначенный для обработки HTTP запросов над сотрудниками
 */
public interface EmployeeController {

    /**
     * HTTP:GET запрос на получение данных обо всех сотрудниках
     * @return массив объектов
     */
    ResponseEntity<List<EmployeeDomainModel>> getRequestFindAllEmployees(@RequestParam Integer pageNumber, @RequestParam Integer elementQuantity);


    /**
     * HTTP:PATCH запрос на обновление данных сотрудника
     * @param employeeDomainModel
     * @return
     */
    ResponseEntity<EmployeeDomainModel> updateRequestUpdateEmployee(EmployeeDomainModel employeeDomainModel);

}
