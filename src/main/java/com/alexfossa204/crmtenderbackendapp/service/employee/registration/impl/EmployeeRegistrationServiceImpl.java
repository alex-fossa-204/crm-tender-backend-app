package com.alexfossa204.crmtenderbackendapp.service.employee.registration.impl;

import com.alexfossa204.crmtenderbackendapp.database.entity.Employee;
import com.alexfossa204.crmtenderbackendapp.database.entity.Technology;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.EmployeeTechnology;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.key.EmployeeTechnologyKey;
import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeTechnologyRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.TechnologyRepository;
import com.alexfossa204.crmtenderbackendapp.service.employee.registration.EmployeeRegistrationService;
import com.alexfossa204.crmtenderbackendapp.service.employee.registration.dto.EmployeeRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.employee.registration.dto.EmployeeRegistrationResponse;
import com.alexfossa204.crmtenderbackendapp.service.employee.domain.dto.EmployeeTechnologyDomain;
import com.alexfossa204.crmtenderbackendapp.service.employee.registration.mapper.EmployeeToEmployeeRegistrationRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService {

    private final EmployeeToEmployeeRegistrationRequestMapper employeeToEmployeeRegistrationRequestMapper;

    private final EmployeeRepository employeeRepository;

    private final TechnologyRepository technologyRepository;

    private final EmployeeTechnologyRepository employeeTechnologyRepository;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    @Override
    public EmployeeRegistrationResponse registerEmployee(EmployeeRegistrationRequest employeeRegistrationRequest) {
        Employee persistedEmployee = employeeRepository.save(
                employeeToEmployeeRegistrationRequestMapper.mapEmployeeRegistrationRequestToEmployeeEntity(employeeRegistrationRequest)
        );

        Map<Technology, String> technologyGradesMap = employeeRegistrationRequest.getTechnologies()
                .stream()
                .collect(
                        Collectors.toMap(
                                employeeTechnologyDomain -> technologyRepository.findByTechnologyName(employeeTechnologyDomain.getTechnologyName()), EmployeeTechnologyDomain::getTechnologyGrade, (key, val) -> key, HashMap::new
                        )
                );

        technologyGradesMap.entrySet()
                .stream()
                .map(persistedTechnology -> EmployeeTechnology.of(
                        EmployeeTechnologyKey.of(persistedEmployee.getId(), persistedTechnology.getKey().getId()),
                        persistedEmployee,
                        persistedTechnology.getKey(),
                        employeeToEmployeeRegistrationRequestMapper.mapEmployeeTechnologyStringToEmployeeTechnologyType(persistedTechnology.getValue()),
                        LocalDateTime.now()
                ))
                .map(employeeTechnologyRepository::save)
                .toList();

        return employeeToEmployeeRegistrationRequestMapper.mapEmployeeEntityToEmployeeRegistrationResponse(persistedEmployee);
    }
}
