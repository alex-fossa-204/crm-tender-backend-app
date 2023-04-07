package com.alexfossa204.crmtenderbackendapp.service.employee.registration.mapper;

import com.alexfossa204.crmtenderbackendapp.database.entity.Employee;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_technology.state.TechnologyGradeType;
import com.alexfossa204.crmtenderbackendapp.service.employee.registration.dto.EmployeeRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.employee.registration.dto.EmployeeRegistrationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;

import static com.alexfossa204.crmtenderbackendapp.config.mapstruct.MapstructConfig.GENERATE_LOCAL_DATE_TIME_EXPRESSION;
import static com.alexfossa204.crmtenderbackendapp.config.mapstruct.MapstructConfig.GENERATE_UUID_EXPRESSION;

/**
 * Компонент предназначенный для преобразования dto в entity
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeToEmployeeRegistrationRequestMapper {

    /**
     * Преобразовать тип dto в тип entity
     *
     * @param employeeRegistrationRequest экземпляр типа для преобразования
     * @return преобразованный экземпляр
     */
    @Mappings(value = {
            @Mapping(target = "employeeGlobalState", source = "employeeGlobalState"),
            @Mapping(target = "employeeUuid", expression = GENERATE_UUID_EXPRESSION),
            @Mapping(target = "registrationTimestamp", expression = GENERATE_LOCAL_DATE_TIME_EXPRESSION),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "technologies", ignore = true)
    })
    Employee mapEmployeeRegistrationRequestToEmployeeEntity(EmployeeRegistrationRequest employeeRegistrationRequest);

    /**
     * Преобразовать тип entity в тип dto
     *
     * @param employeeEntity экземпляр типа для преобразования
     * @return преобразованный экземпляр
     */
    @Mappings(value = {
            @Mapping(target = "employeeGlobalState", source = "employeeGlobalState")
    })
    EmployeeRegistrationResponse mapEmployeeEntityToEmployeeRegistrationResponse(Employee employeeEntity);

    @ValueMappings({
            @ValueMapping(target = "J1", source = "J1"),
            @ValueMapping(target = "J2", source = "J2"),
            @ValueMapping(target = "J3", source = "J3"),
            @ValueMapping(target = "M1", source = "M1"),
            @ValueMapping(target = "M2", source = "M2"),
            @ValueMapping(target = "M3", source = "M3"),
            @ValueMapping(target = "S1", source = "S1"),
            @ValueMapping(target = "S2", source = "S2")
    })
    TechnologyGradeType mapEmployeeTechnologyStringToEmployeeTechnologyType(String technologyGrade);

}
