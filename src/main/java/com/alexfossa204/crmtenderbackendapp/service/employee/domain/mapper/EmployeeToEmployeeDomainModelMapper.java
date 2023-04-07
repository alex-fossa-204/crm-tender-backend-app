package com.alexfossa204.crmtenderbackendapp.service.employee.domain.mapper;

import com.alexfossa204.crmtenderbackendapp.service.employee.domain.dto.EmployeeDomainModel;
import com.alexfossa204.crmtenderbackendapp.database.entity.Employee;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * Компонент, предназначенный для преобразования JPA сущности в POJO сущности
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeToEmployeeDomainModelMapper {

    /**
     * Преобразовать тип entity в тип dto
     *
     * @param employeeEntity экземпляр типа для преобразования
     * @return преобразованный экземпляр
     */

    @Mappings(value = {
            @Mapping(target = "employeeGlobalState", source = "employeeGlobalState"),
            @Mapping(target = "technologies",
                    expression =
                            "java(" +
                                    "employeeEntity.getEmployeeTechnologies().stream()" +
                                    ".map(technology -> EmployeeTechnologyDomain.of(technology.getTechnologyEmployeeTechnology().getTechnologyName(), technology.getTechnologyGrade().name()))" +
                                    ".toList()" +
                                    ")"
            )
    })
    EmployeeDomainModel mapEmployeeEntityToEmployeeDto(Employee employeeEntity);


    /**
     * Преобразовать тип dto в тип entity
     *
     * @param employeeDomainModel экземпляр типа для преобразования
     * @return преобразованный экземпляр
     */

    @Mappings(value = {
            @Mapping(target = "employeeGlobalState", source = "employeeGlobalState"),
    })
    Employee mapEmployeeDtoToEmployeeEntity(EmployeeDomainModel employeeDomainModel);

    /**
     * Обновить данные существующего экзепляра сущности из dto
     *
     * @param employeeDomainModel экземпляр типа для преобразования c обновленными полями
     * @param employee    экзепляр типа, который необходимо обновить
     * @return обновленный экзепляр
     */
    @Mappings(value = {
            @Mapping(target = "technologies", ignore = true)

    })
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Employee updateEmployeeFromEmployeeDto(EmployeeDomainModel employeeDomainModel, @MappingTarget Employee employee);

}
