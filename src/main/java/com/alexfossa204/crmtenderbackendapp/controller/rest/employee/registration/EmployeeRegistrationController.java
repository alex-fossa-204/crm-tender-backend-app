package com.alexfossa204.crmtenderbackendapp.controller.rest.employee.registration;

import com.alexfossa204.crmtenderbackendapp.service.employee.registration.dto.EmployeeRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.employee.registration.dto.EmployeeRegistrationResponse;
import org.springframework.http.ResponseEntity;

/**
 * Компонент, предназначенный для обработки HTTP запросов по регистрации сотрудников в системе
 */
public interface EmployeeRegistrationController {

    /**
     * HTTP:POST запрос на сохранение данных сотрудника
     * @param employeeRegistrationRequest тело запроса
     * @return тело ответа
     */
    ResponseEntity<EmployeeRegistrationResponse> postRequestRegisterEmployee(EmployeeRegistrationRequest employeeRegistrationRequest);

}
