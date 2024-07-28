package com.alexfossa204.crmtenderbackendapp.database.factory;

import com.alexfossa204.crmtenderbackendapp.database.entity.Department;
import com.alexfossa204.crmtenderbackendapp.model.DepartmentData;
import com.alexfossa204.crmtenderbackendapp.model.UserData;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;

public class DepartmentStubFactory {

    private static final Faker faker = new Faker();

    public static Department supplyDepartmentStub(String departmentName, String shortCut, UserData leader) {
        final var dateTime = LocalDateTime.now();
        final var departmentData = new DepartmentData.DepartmentDataBuilder()
                .withName(departmentName)
                .withShortcut(shortCut)
                .withLeader(leader)
                .build();
        return Department.builder()
                .data(departmentData)
                .registrationTimestamp(dateTime)
                .updateTimestamp(dateTime)
                .build();
    }

}
