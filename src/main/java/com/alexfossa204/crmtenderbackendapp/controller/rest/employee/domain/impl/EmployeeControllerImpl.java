package com.alexfossa204.crmtenderbackendapp.controller.rest.employee.domain.impl;

import com.alexfossa204.crmtenderbackendapp.controller.rest.employee.domain.EmployeeController;
import com.alexfossa204.crmtenderbackendapp.service.employee.domain.dto.EmployeeDomainModel;
import com.alexfossa204.crmtenderbackendapp.service.employee.domain.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/employees")
@Tag(name = "Employee Management API", description = "Данный компонент отвечает за предоставления функционала управления над сотрудниками, зарегистрированными в CRM")
public class EmployeeControllerImpl implements EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/all")
    @Override
    public ResponseEntity<List<EmployeeDomainModel>> getRequestFindAllEmployees(@RequestParam Integer pageNumber, @RequestParam Integer elementQuantity) {
        return ResponseEntity.ok(employeeService.findAllEmployees(PageRequest.of(pageNumber, elementQuantity)));
    }

    @PatchMapping("/update")
    @Override
    public ResponseEntity<EmployeeDomainModel> updateRequestUpdateEmployee(@RequestBody EmployeeDomainModel employeeDomainModel) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDomainModel));
    }
}
