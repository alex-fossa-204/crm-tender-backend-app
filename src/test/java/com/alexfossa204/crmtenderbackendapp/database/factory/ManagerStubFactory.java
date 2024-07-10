package com.alexfossa204.crmtenderbackendapp.database.factory;

import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;
import com.alexfossa204.crmtenderbackendapp.database.entity.Role;
import com.alexfossa204.crmtenderbackendapp.database.entity.state.ManagerStateType;
import com.alexfossa204.crmtenderbackendapp.model.Contact;
import com.alexfossa204.crmtenderbackendapp.model.ManagerData;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.util.Set;
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
        var nameWithMiddle = faker.name().nameWithMiddle().split(" ");
        var baseEmail = faker.internet().emailAddress();
        var phoneNumber = faker.phoneNumber().phoneNumber();
        var managerData = new ManagerData.ManagerDataBuilder()
                .withFirstName(nameWithMiddle[0])
                .withMiddleName(nameWithMiddle[1])
                .withLastName(nameWithMiddle[2])
                .withPosition("PM")
                .withContacts(
                        Set.of(
                                new Contact.ContactBuilder()
                                        .withContactType("email")
                                        .withContactValue(baseEmail)
                                        .build(),
                                new Contact.ContactBuilder()
                                        .withContactType("skype")
                                        .withContactValue(baseEmail.split("@")[0])
                                        .build(),
                                new Contact.ContactBuilder()
                                        .withContactType("phoneNumber")
                                        .withContactValue(phoneNumber)
                                        .build(),
                                new Contact.ContactBuilder()
                                        .withContactType("teams")
                                        .withContactValue(baseEmail.split("@")[0])
                                        .build()
                        )
                )
                .build();
        var builder = Manager.builder()
                .managerUuid(UUID.randomUUID())
                .managerState(ManagerStateType.АКТИВНЫЙ)
                .registrationTimestamp(localDataTimeNow)
                .updateTimestamp(localDataTimeNow)
                .managerData(managerData);
        managerBuilderConsumer.accept(builder);
        return builder.build();
    }

}
