package com.alexfossa204.crmtenderbackendapp.database.factory;

import com.alexfossa204.crmtenderbackendapp.database.entity.Customer;
import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;
import com.alexfossa204.crmtenderbackendapp.database.entity.Tender;
import com.alexfossa204.crmtenderbackendapp.database.entity.state.TenderGlobalStateType;
import com.alexfossa204.crmtenderbackendapp.database.entity.state.TenderType;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.util.function.Consumer;

public class TenderStubFactory {

    private static final Faker faker = new Faker();

    public static Tender supplyTenderDefaultStub(Customer customer, Manager tenderManager) {
        return supplyTenderDefaultStub(builder -> {
            builder.customer(customer);
            builder.tenderManager(tenderManager);
        });
    }

    public static Tender supplyTenderDefaultStub(Customer customer) {
        return supplyTenderDefaultStub(builder -> {
            builder.customer(customer);
        });
    }

    public static Tender supplyTenderDefaultStub() {
        return supplyTenderDefaultStub(builder -> {});
    }

    public static Tender supplyTenderDefaultStub(Consumer<Tender.TenderBuilder> tenderBuilderConsumer) {
        var localDateTimeNow = LocalDateTime.now();
        var builder = Tender.builder()
                .tenderUuid(faker.bothify("JK#######BN######PL"))
                .name(String.format("Сбер КИБ 100 живых душ: %s - %s", faker.artist().name(), faker.animal().name()))
                .creationTimestamp(localDateTimeNow)
                .updateTimestamp(localDateTimeNow)
                .deadlineTimestamp(LocalDateTime.of(localDateTimeNow.getYear() + 1, localDateTimeNow.getMonth(), localDateTimeNow.getDayOfMonth(), localDateTimeNow.getHour(), localDateTimeNow.getMinute()))
                .tenderState(TenderGlobalStateType.АКТИВНЫЙ)
                .typeValue(TenderType.ПОДАЧА_КП);

        tenderBuilderConsumer.accept(builder);
        return builder.build();
    }

}
