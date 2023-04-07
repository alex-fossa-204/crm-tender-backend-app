package com.alexfossa204.crmtenderbackendapp.service.employee.domain.impl;

import com.alexfossa204.crmtenderbackendapp.database.entity.Employee;
import com.alexfossa204.crmtenderbackendapp.service.employee.domain.dto.EmployeeDomainModel;
import com.alexfossa204.crmtenderbackendapp.service.employee.domain.mapper.EmployeeToEmployeeDomainModelMapper;
import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeRepository;
import com.alexfossa204.crmtenderbackendapp.service.employee.domain.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeToEmployeeDomainModelMapper employeeToEmployeeDomainModelMapper;

    @Override
    public List<EmployeeDomainModel> findAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeToEmployeeDomainModelMapper::mapEmployeeEntityToEmployeeDto)
                .toList();
    }

    @Override
    public EmployeeDomainModel saveEmployee(EmployeeDomainModel employeeDomainModel) {
        Employee persistedEmployee = employeeRepository.save(
                employeeToEmployeeDomainModelMapper.mapEmployeeDtoToEmployeeEntity(employeeDomainModel)
        );
        return employeeToEmployeeDomainModelMapper.mapEmployeeEntityToEmployeeDto(persistedEmployee);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    @Override
    public EmployeeDomainModel updateEmployee(EmployeeDomainModel employeeDomainModel) {
        var employeeUuid = employeeDomainModel.getEmployeeUuid();
        var employeeOptional = employeeRepository.findByEmployeeUuid(employeeDomainModel.getEmployeeUuid());
        if(employeeOptional.isEmpty()) {
            throw new RuntimeException(String.format("Сотрудник не найден: uuid = %s", employeeUuid));
        }
        var updatedEmployee = employeeRepository.save(
                employeeToEmployeeDomainModelMapper.updateEmployeeFromEmployeeDto(employeeDomainModel, employeeOptional.get())
        );
        return employeeToEmployeeDomainModelMapper.mapEmployeeEntityToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(EmployeeDomainModel employeeDomainModel) {
        var employeeUuid = employeeDomainModel.getEmployeeUuid();
        var employeeOptional = employeeRepository.findByEmployeeUuid(employeeDomainModel.getEmployeeUuid());
        if(employeeOptional.isEmpty()) {
            throw new RuntimeException(String.format("Сотрудник не найден: uuid = %s", employeeUuid));
        }
        employeeRepository.deleteById(employeeOptional.get().getId());
    }
}
