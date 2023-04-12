package com.alexfossa204.crmtenderbackendapp.controller.rest.manager.registration.impl;

import com.alexfossa204.crmtenderbackendapp.controller.rest.manager.registration.ManagerRegistrationController;
import com.alexfossa204.crmtenderbackendapp.service.manager.registration.ManagerRegistrationService;
import com.alexfossa204.crmtenderbackendapp.service.manager.registration.dto.ManagerRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.manager.registration.dto.ManagerRegistrationResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/manager/registration")
@Tag(name = "Manager(User) Management API", description = "Данный компонент отвечает за предоставления функционала управления над менеджерами(пользователями), зарегистрированными в CRM")
public class ManagerRegistrationControllerImpl implements ManagerRegistrationController {

    private final ManagerRegistrationService managerRegistrationService;

    @PostMapping("/new")
    @Override
    public ResponseEntity<ManagerRegistrationResponse> postRequestRegisterManager(@RequestBody ManagerRegistrationRequest managerRegistrationRequest) {
        return ResponseEntity.ok(managerRegistrationService.registerManager(managerRegistrationRequest));
    }
}
