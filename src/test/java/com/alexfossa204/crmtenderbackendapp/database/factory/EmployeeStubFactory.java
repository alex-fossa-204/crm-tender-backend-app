package com.alexfossa204.crmtenderbackendapp.database.factory;

import com.alexfossa204.crmtenderbackendapp.database.entity.Employee;
import com.alexfossa204.crmtenderbackendapp.database.entity.Technology;
import com.alexfossa204.crmtenderbackendapp.database.entity.state.EmployeeGlobalState;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class EmployeeStubFactory {

    public static Employee supplyEmployeeDefaultStub() {
        return supplyEmployeeDefaultStub(builder -> {
        });
    }

    public static Employee supplyEmployeeDefaultStub(List<Technology> technologies) {
        return supplyEmployeeDefaultStub(builder -> {
            builder.technologies(technologies);
        });
    }

    public static Employee supplyEmployeeDefaultStub(Consumer<Employee.EmployeeBuilder> employeeBuilderConsumer) {
        var builder = Employee.builder()
                .employeeUuid(UUID.randomUUID())
                .employeeGlobalState(EmployeeGlobalState.ДОСТУПЕН)
                .firstname("Дмитрий")
                .lastname("Ковальский")
                .middlename("Иванович")
                .contacts(
                        Map.of(
                                "phoneNumber","375291010101",
                                "email", "dima.koval@astondevs.ru",
                                "skype","dima.koval")
                )
                .organisationName("ООО Астон")
                .employeeLocation(
                        Map.of(
                                "country","Belarus",
                                "city", "Minsk",
                                "address","Pobediteley prospect 7A",
                                "postalCode","210011"
                        )
                )
                .experienceBeforeHiringMonth(2.5D)
                .hiringDate(LocalDate.of(2023, 2, 21))
                .generalInfo("Норм парень")
                .employeeDocumentsInfo(Map.of(
                        "passport", "983779853BP8789735NM",
                        "contract", "CON_34079873587878"
                ))
                .currentProjectInfo(Map.of(
                        "projectName", "SBER CIB",
                        "position", "Java Developer"
                ))
                .registrationTimestamp(LocalDateTime.now());
        employeeBuilderConsumer.accept(builder);
        return builder.build();
    }

}
