package com.alexfossa204.crmtenderbackendapp.controller.rest.manager;

import com.alexfossa204.crmtenderbackendapp.controller.rest.base.dto.delete.BaseDeleteResponse;
import com.alexfossa204.crmtenderbackendapp.controller.rest.manager.dto.ManagerPageResponse;
import com.alexfossa204.crmtenderbackendapp.service.manager.domain.ManagerDomainService;
import com.alexfossa204.crmtenderbackendapp.service.manager.registration.ManagerRegistrationService;
import com.alexfossa204.crmtenderbackendapp.service.manager.registration.dto.ManagerRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.manager.registration.dto.ManagerRegistrationResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/managers")
@Tag(name = "Manager(User) Management API", description = "Данный компонент отвечает за предоставление функционала управления над менеджерами(пользователями), зарегистрированными в CRM")
public class ManagerController {

    private final ManagerRegistrationService managerRegistrationService;

    private final ManagerDomainService managerDomainService;

    /**
     * REST: POST запрос на сохранение данных менеджера
     * @param managerRegistrationRequest тело запроса
     * @return тело ответа
     */
    @PostMapping("/registration")
    public ResponseEntity<ManagerRegistrationResponse> postRequestRegisterManager(@RequestBody ManagerRegistrationRequest managerRegistrationRequest) {
        return ResponseEntity.ok(managerRegistrationService.registerManager(managerRegistrationRequest));
    }

    /**
     * REST:GET запрос на получении данных обо всех менеджерах
     * @return массив объектов
     */
    @GetMapping("/page")
    public ResponseEntity<ManagerPageResponse> getRequestFindAllManagers(@RequestParam Integer id, @RequestParam Integer items) {
        return ResponseEntity.ok(
                managerDomainService.selectManagerPage(PageRequest.of(id, items))
        );
    }

    /**
     * REST:DELETE запрос на удаление менеджера из системы
     * @return массив объектов
     */
    //todo добавить обработку исключений
    //todo добавить кодировку рантайма
    //todo переделать удаление из таблицы на стороне реакта
    @DeleteMapping("/deletion/{managerUuid}")
    public ResponseEntity<BaseDeleteResponse> deleteRequestManager(@PathVariable String managerUuid) {
        return ResponseEntity.ok(
                managerDomainService.deleteManager(managerUuid)
        );
    }

}
