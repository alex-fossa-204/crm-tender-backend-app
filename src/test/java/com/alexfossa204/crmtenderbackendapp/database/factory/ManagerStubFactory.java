package com.alexfossa204.crmtenderbackendapp.database.factory;

import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;
import com.alexfossa204.crmtenderbackendapp.database.entity.Role;
import com.alexfossa204.crmtenderbackendapp.database.entity.state.ManagerStateType;
import com.alexfossa204.crmtenderbackendapp.model.*;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
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
        var position = new PositionData.PositionDataBuilder()
                .withShortcut("PC")
                .withFullPosition("Project Coordinator")
                .withGrade("J2")
                .build();
        var positionSet = new HashSet<>();
        positionSet.add(position);

        var leaderContactSet = new HashSet<>();
        leaderContactSet.add(new ContactData.ContactDataBuilder()
                .withContactType("Skype")
                .withContactValue("bigBossSkype")
                .build());
        leaderContactSet.add(new ContactData.ContactDataBuilder()
                .withContactType("VK Teams")
                .withContactValue("bigBossTeams")
                .build());
        leaderContactSet.add(new ContactData.ContactDataBuilder()
                .withContactType("Email")
                .withContactValue("bigBossEmail")
                .build());
        leaderContactSet.add(new ContactData.ContactDataBuilder()
                .withContactType("Phone")
                .withContactValue("+375 29 456-45-84")
                .build());

        var leader = new UserData.UserDataBuilder()
                .withFirstName("Дмитрий")
                .withMiddleName("Иванович")
                .withLastName("Степанов")
                .withBirthDate(LocalDate.now().toString())
                .withContacts(leaderContactSet)
                .withPositions(positionSet)
                .build();

        var userContacts = new HashSet<>();
        userContacts.add(new ContactData.ContactDataBuilder()
                .withContactType("Skype")
                .withContactValue(phoneNumber)
                .build());
        userContacts.add(new ContactData.ContactDataBuilder()
                .withContactType("VK Teams")
                .withContactValue(baseEmail)
                .build());
        userContacts.add(new ContactData.ContactDataBuilder()
                .withContactType("Email")
                .withContactValue(baseEmail)
                .build());
        userContacts.add(new ContactData.ContactDataBuilder()
                .withContactType("Phone")
                .withContactValue(baseEmail)
                .build());

        var personalInfo = new PersonalInfo.PersonalInfoBuilder()
                .withFirstName(nameWithMiddle[0])
                .withMiddleName(nameWithMiddle[1])
                .withLastName(nameWithMiddle[2])
                .withBirthDate(localDataTimeNow.toString())
                .withPositions(positionSet)
                .withContacts(userContacts)
                .build();

        var fidbackDataSet = new HashSet<>();
        fidbackDataSet.add(new FidbackData.FidbackDataBuilder()
                .withId("1")
                .withType("GENERAL")
                .withCreationDate(LocalDate.now().toString())
                .withApproveDate(LocalDate.now().toString())
                .withPersonStrengths("Сотрудник всегда оперативно выходит на связь, общается вежливо и приветливо. На исполнении сейчас находится одна большая задача по переходу с легаси, которую получил в феврале. Срок сдачи стоит на конец 1квартала 2024. Данный срок исполнения Сотрудник считает маловероятным, о чем открыто сообщает менеджменту.  Впереди еще много работы. В команде появился новый техлид, который активно оказывает помощь. Сотрудник  старается открыто и подробно рассказывать на дейли о проделанной работе и всех задачах, которые перед ним стоят, подсвечивает все сложности. Замечаний по производительности от РО не получает.  Сложность задачи сейчас  чуть ниже чем была за счет уже проделанной работы, но все же остается высокой. Приходится овертаймить, чтобы приблизится к тому сроку исполнения задачи, который был определен менеджментом. Сотрудник настроен дальше оставаться в компании и развиваться как специалист")
                .withWhatToImprove("Продолжать открыто заявлять о возникающих сложностях при реализации задачи менеджменту проекта, а также подробно рассказывать о проделанной работе.")
                .withOwner(leader)
                .build());
        fidbackDataSet.add(new FidbackData.FidbackDataBuilder()
                .withId("2")
                .withType("GENERAL")
                .withCreationDate(LocalDate.now().toString())
                .withApproveDate(LocalDate.now().toString())
                .withPersonStrengths("Сотрудник всегда оперативно выходит на связь, общается вежливо и приветливо. На исполнении сейчас находится одна большая задача по переходу с легаси, которую получил в феврале. Срок сдачи стоит на конец 1квартала 2024. Данный срок исполнения Сотрудник считает маловероятным, о чем открыто сообщает менеджменту.  Впереди еще много работы. В команде появился новый техлид, который активно оказывает помощь. Сотрудник  старается открыто и подробно рассказывать на дейли о проделанной работе и всех задачах, которые перед ним стоят, подсвечивает все сложности. Замечаний по производительности от РО не получает.  Сложность задачи сейчас  чуть ниже чем была за счет уже проделанной работы, но все же остается высокой. Приходится овертаймить, чтобы приблизится к тому сроку исполнения задачи, который был определен менеджментом. Сотрудник настроен дальше оставаться в компании и развиваться как специалист")
                .withWhatToImprove("Продолжать открыто заявлять о возникающих сложностях при реализации задачи менеджменту проекта, а также подробно рассказывать о проделанной работе.")
                .withOwner(leader)
                .build());
        fidbackDataSet.add(
                new FidbackData.FidbackDataBuilder()
                        .withId("3")
                        .withType("GENERAL")
                        .withCreationDate(LocalDate.now().toString())
                        .withApproveDate(LocalDate.now().toString())
                        .withPersonStrengths("Сотрудник всегда оперативно выходит на связь, общается вежливо и приветливо. На исполнении сейчас находится одна большая задача по переходу с легаси, которую получил в феврале. Срок сдачи стоит на конец 1квартала 2024. Данный срок исполнения Сотрудник считает маловероятным, о чем открыто сообщает менеджменту.  Впереди еще много работы. В команде появился новый техлид, который активно оказывает помощь. Сотрудник  старается открыто и подробно рассказывать на дейли о проделанной работе и всех задачах, которые перед ним стоят, подсвечивает все сложности. Замечаний по производительности от РО не получает.  Сложность задачи сейчас  чуть ниже чем была за счет уже проделанной работы, но все же остается высокой. Приходится овертаймить, чтобы приблизится к тому сроку исполнения задачи, который был определен менеджментом. Сотрудник настроен дальше оставаться в компании и развиваться как специалист")
                        .withWhatToImprove("Продолжать открыто заявлять о возникающих сложностях при реализации задачи менеджменту проекта, а также подробно рассказывать о проделанной работе.")
                        .withOwner(leader)
                        .build()
        );

        var teamDataSet = new HashSet<>();
        teamDataSet.add(
                new TeamData.TeamDataBuilder()
                        .withName("Суп из 7 залуп")
                        .withPosition(position)
                        .withAllocation("3")
                        .withStartDate(LocalDate.now().toString())
                        .withStartDate("")
                        .withLeader(leader)
                        .withFidbacks(fidbackDataSet)
                        .build()
        );

        var managerData = new ManagerData.ManagerDataBuilder()
                .withPersonalInfo(personalInfo)
                .build();
        var builder = Manager.builder()
                .managerUuid(UUID.randomUUID())
                .registrationTimestamp(localDataTimeNow)
                .updateTimestamp(localDataTimeNow)
                .managerData(managerData);
        managerBuilderConsumer.accept(builder);
        return builder.build();
    }

}
