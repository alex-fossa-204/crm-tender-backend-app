package com.alexfossa204.crmtenderbackendapp.controller.rest.lot.registration.impl;

import com.alexfossa204.crmtenderbackendapp.controller.rest.lot.registration.LotRegistrationController;
import com.alexfossa204.crmtenderbackendapp.service.lot.registration.LotRegistrationService;
import com.alexfossa204.crmtenderbackendapp.service.lot.registration.dto.LotRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.lot.registration.dto.LotRegistrationResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lot/registration")
@Tag(name = "Lot Management API", description = "Данный компонент отвечает за предоставления функционала управления над лотами, зарегистрированными в CRM")
public class LotRegistrationControllerImpl implements LotRegistrationController {

    private final LotRegistrationService lotRegistrationService;

    @PostMapping("/new")
    @Override
    public ResponseEntity<LotRegistrationResponse> postRequestRegisterLot(@RequestBody LotRegistrationRequest lotRegistrationRequest) {
        return ResponseEntity.ok(lotRegistrationService.registerNewLot(lotRegistrationRequest));
    }
}
