package com.alexfossa204.crmtenderbackendapp.database.factory;

import com.alexfossa204.crmtenderbackendapp.database.entity.Customer;
import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;
import com.alexfossa204.crmtenderbackendapp.database.entity.Tender;
import com.alexfossa204.crmtenderbackendapp.database.entity.state.TenderGlobalStateType;
import com.alexfossa204.crmtenderbackendapp.database.entity.state.TenderType;
import com.github.javafaker.Faker;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
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
        var builder = Tender.builder()
                .tenderNumber(faker.bothify("JK#######BN######PL"))
                .tenderName(String.format("Сбер КИБ 100 живых душ: %s - %s", faker.artist().name(), faker.animal().name()))
                .tenderGlobalState(TenderGlobalStateType.АКТИВНЫЙ)
                .tenderTypeValue(TenderType.ПОДАЧА_КП)
                .tenderDescription(
                        Map.of(
                                "header", "Stubbed text data",
                                "body", "Stubbed text data",
                                "footer", "Stubbed text data"
                        )
                )
                .tenderCreationTimestamp(LocalDateTime.now())
                .tenderUpdateTimestamp(LocalDateTime.now())
                .tenderDeadlineTimestamp(LocalDateTime.of(2023, 9, 21, 15, 0))
                .tenderBaseLotQuantity(5)
                .tenderFinalLotQuantity(10)
                .tenderNmcCost(BigDecimal.valueOf(35000.00D))
                .tenderFinalCost(BigDecimal.valueOf(75000.00D))
                .organisations(
                        Map.of(
                                "organisations", List.of("Andersen", "Aston")
                        )
                )
                .bankGuaranty(true)
                .tenderEstimationCriteria(
                        Map.of(
                                "criteria1", "Stubbed text data",
                                "criteria2", "Stubbed text data",
                                "criteria3", "Stubbed text data"
                        )
                )
                .employeeDocumentRequirements(
                        Map.of(
                                "requirement1", "Stubbed text data",
                                "requirement2", "Stubbed text data",
                                "requirement3", "Stubbed text data"
                        )
                );


        tenderBuilderConsumer.accept(builder);
        return builder.build();
    }

}
