package com.alexfossa204.crmtenderbackendapp.database.factory;

import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;
import com.alexfossa204.crmtenderbackendapp.database.entity.Role;
import com.alexfossa204.crmtenderbackendapp.database.entity.enums.ManagerStateType;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class ManagerStubFactory {

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
        var builder = Manager.builder()
                .managerState(ManagerStateType.АКТИВНЫЙ)
                .managerUuid(UUID.randomUUID())
                .firstname("Виктор")
                .lastname("Иванов")
                .middlename("Андреевич")
                .contacts(
                        Map.of(
                                "phoneNumber", "375291010101",
                                "email", "dima.koval@astondevs.ru",
                                "skype", "dima.koval")
                )
                .registrationTimestamp(LocalDateTime.now())
                .updateTimestamp(LocalDateTime.now())
                .generalInfo("Норм парень")
                .email("ivanov.viktor.pm@astondevs.ru")
                .login("v.ivanov.pm")
                .password("12345");
        managerBuilderConsumer.accept(builder);
        return builder.build();
    }

}
