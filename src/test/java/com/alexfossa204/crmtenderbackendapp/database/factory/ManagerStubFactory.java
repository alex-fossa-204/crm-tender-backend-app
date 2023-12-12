package com.alexfossa204.crmtenderbackendapp.database.factory;

import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;
import com.alexfossa204.crmtenderbackendapp.database.entity.Role;
import com.alexfossa204.crmtenderbackendapp.database.entity.state.ManagerStateType;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.util.Map;
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
        var generatedEmail = faker.internet().emailAddress();
        var generatedLogin = faker.name().username();
        var builder = Manager.builder()
                .managerState(ManagerStateType.АКТИВНЫЙ)
                .managerUuid(UUID.randomUUID())
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .middlename("Андреевич")
                .contacts(
                        Map.of(
                                "phoneNumber", "375291010101",
                                "email", generatedEmail,
                                "skype", "dima.koval")
                )
                .registrationTimestamp(LocalDateTime.now())
                .updateTimestamp(LocalDateTime.now())
                .generalInfo("Норм парень")
                .email(generatedEmail)
                .login(generatedLogin)
                .password("12345");
        managerBuilderConsumer.accept(builder);
        return builder.build();
    }

}
