package com.alexfossa204.crmtenderbackendapp.controller.rest.lot;

import com.alexfossa204.crmtenderbackendapp.service.lot.domain.LotService;
import com.alexfossa204.crmtenderbackendapp.service.lot.domain.dto.LotDomainModel;
import com.alexfossa204.crmtenderbackendapp.service.lot.registration.LotRegistrationService;
import com.alexfossa204.crmtenderbackendapp.service.lot.registration.dto.LotRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.lot.registration.dto.LotRegistrationResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lots/management")
@Tag(name = "Lot Management API", description = "Данный компонент отвечает за предоставления функционала управления над лотами, зарегистрированными в CRM")
public class LotController {

    private final LotRegistrationService lotRegistrationService;

    private final LotService lotService;

    /**
     * HTTP: POST запрос на сохранение данных лота
     * @param lotRegistrationRequest тело запроса
     * @return тело ответа
     */
    @PostMapping("/registration")
    public ResponseEntity<LotRegistrationResponse> postRequestRegisterLot(@RequestBody LotRegistrationRequest lotRegistrationRequest) {
        return ResponseEntity.ok(lotRegistrationService.registerNewLot(lotRegistrationRequest));
    }

    /**
     * HTTP:GET запрос на получение данных обо всех лотах
     *
     * @return массив объектов
     */
    @GetMapping("/all")
    public ResponseEntity<List<LotDomainModel>> getRequestFindAllLots(@RequestParam Integer pageNumber, @RequestParam Integer elementQuantity) {
        return ResponseEntity.ok(lotService.findAllLots(PageRequest.of(pageNumber, elementQuantity)));
    }
}
