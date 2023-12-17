package com.alexfossa204.crmtenderbackendapp.database.factory;

import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;
import com.alexfossa204.crmtenderbackendapp.database.entity.Role;
import com.alexfossa204.crmtenderbackendapp.database.entity.state.ManagerStateType;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Consumer;

public class ManagerStubFactory {

    private static final Faker faker = new Faker();

    public static Manager supplyManagerDefaultStub(Role role) {
        return supplyManagerDefaultStub(builder -> {
            builder.role(role);
        });
    }

    public static Manager supplyManagerDefaultStub() {
        return supplyManagerDefaultStub(builder -> {
        });
    }

    public static Manager supplyManagerDefaultStub(Consumer<Manager.ManagerBuilder> managerBuilderConsumer) {
        var localDataTimeNow = LocalDateTime.now();
        var builder = Manager.builder()
                .managerState(ManagerStateType.АКТИВНЫЙ)
                .registrationTimestamp(localDataTimeNow)
                .updateTimestamp(localDataTimeNow)
                .managerUuid(UUID.randomUUID());
        managerBuilderConsumer.accept(builder);
        return builder.build();
    }

}
