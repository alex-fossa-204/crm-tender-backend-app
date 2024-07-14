package com.alexfossa204.crmtenderbackendapp.controller.rest.commons.role;

import com.alexfossa204.crmtenderbackendapp.service.role.domain.RoleDomainService;
import com.alexfossa204.crmtenderbackendapp.service.role.domain.dto.RoleDomainModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/roles")
@Tag(name = "System User Role API", description = "Данный компонент отвечает за предоставление функционала управления над ролями пользователей, зарегистрированных в CRM")
public class UserRoleController {

    private final RoleDomainService roleDomainService;

    @GetMapping("/all")
    public ResponseEntity<List<RoleDomainModel>> getAllRoles() {
        return ResponseEntity.ok(
                roleDomainService.findAllRoles()
        );
    }

}
