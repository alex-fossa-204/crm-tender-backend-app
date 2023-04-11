package com.alexfossa204.crmtenderbackendapp.service.employee.registration;

import com.alexfossa204.crmtenderbackendapp.service.employee.registration.dto.EmployeeRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.employee.registration.dto.EmployeeRegistrationResponse;

/**
 * Компонент, предназначенный для регистрации сотрудников в системе
 */
public interface EmployeeRegistrationService {

    /**
     * Зарегистрировать сотрудника в системе
     * @param employeeRegistrationRequest запрос на регистрацию сотрудника
     * @return ответ на запрос о регистрации сотрудника в системе
     */
    EmployeeRegistrationResponse registerEmployee(EmployeeRegistrationRequest employeeRegistrationRequest);

}
