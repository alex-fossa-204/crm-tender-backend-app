package com.alexfossa204.crmtenderbackendapp.database.factory;

import com.alexfossa204.crmtenderbackendapp.database.entity.Lot;
import com.alexfossa204.crmtenderbackendapp.database.entity.Tender;
import com.alexfossa204.crmtenderbackendapp.database.entity.enums.LotGlobalStateType;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class LotStubFactory {

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
        var builder = Lot.builder()
                .lotState(LotGlobalStateType.АКТИВНЫЙ)
                .lotUuid(UUID.randomUUID())
                .lotData(
                        Map.of(
                                "lot", "Тестовые данные лота",
                                "lot_meta", "Тетсовые метаданные лота"
                        )
                )
                .lotCreationTimestamp(LocalDateTime.now())
                .lotUpdateTimestamp(LocalDateTime.now());

        lotBuilderConsumer.accept(builder);
        return builder.build();
    }

}
