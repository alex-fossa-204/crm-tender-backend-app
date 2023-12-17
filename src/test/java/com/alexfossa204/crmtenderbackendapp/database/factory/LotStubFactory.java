package com.alexfossa204.crmtenderbackendapp.database.factory;

import com.alexfossa204.crmtenderbackendapp.database.entity.Lot;
import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;
import com.alexfossa204.crmtenderbackendapp.database.entity.Tender;
import com.alexfossa204.crmtenderbackendapp.database.entity.state.LotGlobalStateType;
import com.alexfossa204.crmtenderbackendapp.database.entity.state.LotType;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Consumer;

public class LotStubFactory {

    private static final Faker faker = new Faker();



    public static Lot supplyLotDefaultStub(Tender tender, Manager lotManager) {
        return supplyLotDefaultStub(lotBuilder -> {
            lotBuilder.tender(tender);
            lotBuilder.lotManager(lotManager);
        });
    }

    public static Lot supplyLotDefaultStub(Tender tender) {
        return supplyLotDefaultStub(lotBuilder -> {
            lotBuilder.tender(tender);
        });
    }

    public static Lot supplyLotDefaultStub() {
        return supplyLotDefaultStub(lotBuilder -> {
        });
    }

    public static Lot supplyLotDefaultStub(Consumer<Lot.LotBuilder> lotBuilderConsumer) {
        var localDateTimeNow = LocalDateTime.now();
        var builder = Lot.builder()
                .lotState(LotGlobalStateType.АКТИВНЫЙ)
                .typeValue(LotType.ПОДАЧА_КП)
                .lotUuid(UUID.randomUUID())
                .name(String.format("Java Senior Developer Lot: %s %s %s", faker.artist().name(), faker.animal().name(), faker.name().username()))
                .creationTimestamp(localDateTimeNow)
                .updateTimestamp(localDateTimeNow)
                .deadlineTimestamp(LocalDateTime.of(localDateTimeNow.getYear() + 1, localDateTimeNow.getMonth(), localDateTimeNow.getDayOfMonth(), localDateTimeNow.getHour(), localDateTimeNow.getMinute()));

        lotBuilderConsumer.accept(builder);
        return builder.build();
    }

}
