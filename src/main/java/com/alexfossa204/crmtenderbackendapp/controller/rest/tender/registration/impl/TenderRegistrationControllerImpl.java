package com.alexfossa204.crmtenderbackendapp.controller.rest.tender.registration.impl;

import com.alexfossa204.crmtenderbackendapp.controller.rest.tender.registration.TenderRegistrationController;
import com.alexfossa204.crmtenderbackendapp.service.tender.registration.TenderRegistrationService;
import com.alexfossa204.crmtenderbackendapp.service.tender.registration.dto.TenderRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.tender.registration.dto.TenderRegistrationResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tenders/registration")
@Tag(name = "Tender Management API", description = "Данный компонент отвечает за предоставление функционала по управлению данными тендеров")
public class TenderRegistrationControllerImpl implements TenderRegistrationController {

    private final TenderRegistrationService tenderRegistrationService;

    @PostMapping("/new")
    @Override
    public ResponseEntity<TenderRegistrationResponse> postRequestRegisterTender(@RequestBody TenderRegistrationRequest tenderRegistrationRequest) {
        return ResponseEntity.ok(tenderRegistrationService.registerNewTender(tenderRegistrationRequest));
    }
}
