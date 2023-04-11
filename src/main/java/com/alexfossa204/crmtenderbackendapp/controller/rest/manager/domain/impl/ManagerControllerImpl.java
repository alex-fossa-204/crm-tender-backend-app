package com.alexfossa204.crmtenderbackendapp.controller.rest.manager.domain.impl;

import com.alexfossa204.crmtenderbackendapp.controller.rest.manager.domain.ManagerController;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.ManagerService;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.dto.ManagerDomainModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/managers")
@Tag(name = "Manager(User) Management API", description = "Данный компонент отвечает за предоставления функционала управления над менеджерами(пользователями), зарегистрированными в CRM")
public class ManagerControllerImpl implements ManagerController {

    private final ManagerService managerService;

    @GetMapping("/all")
    @Override
    public ResponseEntity<List<ManagerDomainModel>> getRequestFindAllManagers() {
        return ResponseEntity.ok(managerService.findAllManagers());
    }
}
