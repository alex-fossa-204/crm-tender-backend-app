package com.alexfossa204.crmtenderbackendapp.database.factory;

import com.alexfossa204.crmtenderbackendapp.database.entity.Department;
import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;
import com.alexfossa204.crmtenderbackendapp.model.DepartmentData;
import com.alexfossa204.crmtenderbackendapp.model.UserData;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.util.UUID;

public class DepartmentStubFactory {

    private static final Faker faker = new Faker();

    public static Department supplyDepartmentStub(String departmentName, String shortCut, Manager leaderEntity, String companyName) {
        final var dateTime = LocalDateTime.now();
        final var departmentData = new DepartmentData.DepartmentDataBuilder()
                .withName(departmentName)
                .withShortcut(shortCut)
                .withCompanyName(companyName)
                .build();
        return Department.builder()
                .departmentUuid(UUID.randomUUID())
                .data(departmentData)
                .registrationTimestamp(dateTime)
                .updateTimestamp(dateTime)
                .leader(leaderEntity)
                .build();
    }

}
