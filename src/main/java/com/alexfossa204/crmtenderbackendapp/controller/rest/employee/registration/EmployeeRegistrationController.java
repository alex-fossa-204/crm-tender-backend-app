package com.alexfossa204.crmtenderbackendapp.controller.rest.employee.registration;

import com.alexfossa204.crmtenderbackendapp.service.employee.registration.dto.EmployeeRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.employee.registration.dto.EmployeeRegistrationResponse;
import org.springframework.http.ResponseEntity;

public interface EmployeeRegistrationController {

    /**
     * HTTP:POST запрос на сохранение данных сотрудника
     * @param employeeRegistrationRequest
     * @return
     */
    ResponseEntity<EmployeeRegistrationResponse> postRequestSaveEmployee(EmployeeRegistrationRequest employeeRegistrationRequest);

}
