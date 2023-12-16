package com.alexfossa204.crmtenderbackendapp.controller.rest.tender;

import com.alexfossa204.crmtenderbackendapp.controller.rest.tender.dto.TenderPageResponse;
import com.alexfossa204.crmtenderbackendapp.service.tender.domain.TenderDomainService;
import com.alexfossa204.crmtenderbackendapp.service.tender.registration.TenderRegistrationService;
import com.alexfossa204.crmtenderbackendapp.service.tender.registration.dto.TenderRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.tender.registration.dto.TenderRegistrationResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tenders/management")
@Tag(name = "Tender Management API", description = "Данный компонент отвечает за предоставление функционала по управлению данными тендеров")
public class TenderController {

    private final TenderRegistrationService tenderRegistrationService;

    private final TenderDomainService tenderDomainService;

    /**
     * HTTP:POST запрос на сохранение данных тендера
     * @param tenderRegistrationRequest тело запроса
     * @return тело ответа
     */
    @PostMapping("/registration")
    public ResponseEntity<TenderRegistrationResponse> postRequestRegisterTender(@RequestBody TenderRegistrationRequest tenderRegistrationRequest) {
        return ResponseEntity.ok(tenderRegistrationService.registerNewTender(tenderRegistrationRequest));
    }

    /**
     * HTTP:GET получить данные обо всех тендерах
     * @return массив объектов
     */
    @GetMapping("/page")
    public ResponseEntity<TenderPageResponse> getRequestFindAllTenders(@RequestParam Integer id, @RequestParam Integer items) {
        return ResponseEntity.ok(tenderDomainService.selectTenderPage(PageRequest.of(id, items)));
    }

}
