package com.alexfossa204.crmtenderbackendapp.service.impl;

import com.alexfossa204.crmtenderbackendapp.database.entity.Employee;
import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeRepository;
import com.alexfossa204.crmtenderbackendapp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.deleteById(employee.getId());
    }
}
