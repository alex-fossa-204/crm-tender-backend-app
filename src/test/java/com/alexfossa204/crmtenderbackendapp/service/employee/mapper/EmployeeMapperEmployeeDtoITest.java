package com.alexfossa204.crmtenderbackendapp.service.employee.mapper;

import com.alexfossa204.crmtenderbackendapp.database.entity.Employee;
import com.alexfossa204.crmtenderbackendapp.database.factory.bean.EmployeeWithTechnologyStubFactory;
import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeRepository;
import com.alexfossa204.crmtenderbackendapp.service.employee.domain.dto.EmployeeDomainModel;
import com.alexfossa204.crmtenderbackendapp.service.employee.domain.mapper.EmployeeToEmployeeDomainModelMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
public class EmployeeMapperEmployeeDtoITest {

    @Autowired
    private EmployeeWithTechnologyStubFactory employeeWithTechnologyStubFactory;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeToEmployeeDomainModelMapper employeeToEmployeeDomainModelMapper;

    @BeforeEach
    void beforeEach() {
        employeeWithTechnologyStubFactory.supplyEmployeeWithTechnology("Java");
    }

    @AfterEach
    void afterEach() {
        employeeWithTechnologyStubFactory.flushTestObjects();
    }


    @Test
    void when_employeeEntity_map_to_employeeDto() {
        Employee persistedEmployee = employeeRepository.findAll().stream()
                .findFirst().orElseThrow(() -> new RuntimeException("No value present"));

        EmployeeDomainModel employeeDomainModel = employeeToEmployeeDomainModelMapper.mapEmployeeEntityToEmployeeDto(persistedEmployee);

        assertAll("Проверка корректности маппинга полей",
                () -> assertThat(employeeDomainModel.getEmployeeUuid(), is(equalTo(persistedEmployee.getEmployeeUuid()))),
                () -> assertThat(employeeDomainModel.getEmployeeGlobalState(), is(equalTo(persistedEmployee.getEmployeeGlobalState().name()))),
                () -> assertThat(employeeDomainModel.getFirstname(), is(equalTo(persistedEmployee.getFirstname()))),
                () -> assertThat(employeeDomainModel.getLastname(), is(equalTo(persistedEmployee.getLastname()))),
                () -> assertThat(employeeDomainModel.getMiddlename(), is(equalTo(persistedEmployee.getMiddlename()))),
                () -> assertThat(employeeDomainModel.getContacts(), is(equalTo(persistedEmployee.getContacts()))),
                () -> assertThat(employeeDomainModel.getOrganisationName(), is(equalTo(persistedEmployee.getOrganisationName()))),
                () -> assertThat(employeeDomainModel.getEmployeeLocation(), is(equalTo(persistedEmployee.getEmployeeLocation()))),
                () -> assertThat(employeeDomainModel.getExperienceBeforeHiringMonth(), is(equalTo(persistedEmployee.getExperienceBeforeHiringMonth()))),
                () -> assertThat(employeeDomainModel.getHiringDate(), is(equalTo(persistedEmployee.getHiringDate()))),
                () -> assertThat(employeeDomainModel.getGeneralInfo(), is(equalTo(persistedEmployee.getGeneralInfo()))),
                () -> assertThat(employeeDomainModel.getEmployeeDocumentsInfo(), is(equalTo(persistedEmployee.getEmployeeDocumentsInfo()))),
                () -> assertThat(employeeDomainModel.getCurrentProjectInfo(), is(equalTo(persistedEmployee.getCurrentProjectInfo())))
        );
    }

    @Test
    void when_employeeDto_map_to_EmployeeEntity_and_persist() {
        UUID uuid = UUID.randomUUID();
        EmployeeDomainModel employeeDomainModel = EmployeeDomainModel.builder()
                .employeeUuid(uuid)
                .employeeGlobalState("ДОСТУПЕН")
                .firstname("Alexey")
                .middlename("Ivanovich")
                .lastname("Ivanov")
                .contacts(
                        Map.of(
                                "phoneNumber", "375291010190",
                                "email", "alex.ivanov@astondevs.ru",
                                "skype", "alex.ivan09"
                        )
                )
                .organisationName("OOO Aston")
                .employeeLocation(
                        Map.of(
                                "country", "Belarus",
                                "city", "Minsk",
                                "address", "Pobediteley prospect 7A",
                                "postalCode", "210011"
                        )
                )
                .experienceBeforeHiringMonth(2.5D)
                .hiringDate(LocalDate.of(2023, 2, 21))
                .employeeDocumentsInfo(Map.of(
                                "passport", "983779853BP8789735NM",
                                "contract", "CON_34079873587878"
                        )
                )
                .generalInfo("Норм парень")
                .employeeDocumentsInfo(Map.of(
                                "passport", "983779853BP8789735NM",
                                "contract", "CON_34079873587878"
                        )
                )
                .currentProjectInfo(Map.of(
                                "projectName", "SBER CIB",
                                "position", "Java Developer"
                        )
                )
                .build();

        Employee transformedDetachedEmployee = employeeToEmployeeDomainModelMapper.mapEmployeeDtoToEmployeeEntity(employeeDomainModel);

        assertAll("Проверка корректности маппинга полей",
                () -> assertThat(employeeDomainModel.getEmployeeUuid(), is(equalTo(transformedDetachedEmployee.getEmployeeUuid()))),
                () -> assertThat(employeeDomainModel.getEmployeeGlobalState(), is(equalTo(transformedDetachedEmployee.getEmployeeGlobalState().name()))),
                () -> assertThat(employeeDomainModel.getFirstname(), is(equalTo(transformedDetachedEmployee.getFirstname()))),
                () -> assertThat(employeeDomainModel.getLastname(), is(equalTo(transformedDetachedEmployee.getLastname()))),
                () -> assertThat(employeeDomainModel.getMiddlename(), is(equalTo(transformedDetachedEmployee.getMiddlename()))),
                () -> assertThat(employeeDomainModel.getContacts(), is(equalTo(transformedDetachedEmployee.getContacts()))),
                () -> assertThat(employeeDomainModel.getOrganisationName(), is(equalTo(transformedDetachedEmployee.getOrganisationName()))),
                () -> assertThat(employeeDomainModel.getEmployeeLocation(), is(equalTo(transformedDetachedEmployee.getEmployeeLocation()))),
                () -> assertThat(employeeDomainModel.getExperienceBeforeHiringMonth(), is(equalTo(transformedDetachedEmployee.getExperienceBeforeHiringMonth()))),
                () -> assertThat(employeeDomainModel.getHiringDate(), is(equalTo(transformedDetachedEmployee.getHiringDate()))),
                () -> assertThat(employeeDomainModel.getGeneralInfo(), is(equalTo(transformedDetachedEmployee.getGeneralInfo()))),
                () -> assertThat(employeeDomainModel.getEmployeeDocumentsInfo(), is(equalTo(transformedDetachedEmployee.getEmployeeDocumentsInfo()))),
                () -> assertThat(employeeDomainModel.getCurrentProjectInfo(), is(equalTo(transformedDetachedEmployee.getCurrentProjectInfo())))
        );

    }

}
