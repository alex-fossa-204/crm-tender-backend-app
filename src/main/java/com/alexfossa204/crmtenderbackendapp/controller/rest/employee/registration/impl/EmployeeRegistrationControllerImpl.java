package com.alexfossa204.crmtenderbackendapp.controller.rest.employee.registration.impl;

import com.alexfossa204.crmtenderbackendapp.controller.rest.employee.registration.EmployeeRegistrationController;
import com.alexfossa204.crmtenderbackendapp.service.employee.registration.EmployeeRegistrationService;
import com.alexfossa204.crmtenderbackendapp.service.employee.registration.dto.EmployeeRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.employee.registration.dto.EmployeeRegistrationResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/employee/registration")
@Tag(name = "Employee Management API", description = "Данный компонент отвечает за предоставления функционала управления над сотрудниками, зарегистрированными в CRM")
public class EmployeeRegistrationControllerImpl implements EmployeeRegistrationController {

    private final EmployeeRegistrationService employeeRegistrationService;

    @PostMapping("/new")
    @Override
    public ResponseEntity<EmployeeRegistrationResponse> postRequestRegisterEmployee(@RequestBody EmployeeRegistrationRequest employeeRegistrationRequest) {
        return ResponseEntity.ok(employeeRegistrationService.registerEmployee(employeeRegistrationRequest));
    }
}
