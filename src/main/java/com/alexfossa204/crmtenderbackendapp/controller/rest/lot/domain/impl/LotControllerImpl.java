package com.alexfossa204.crmtenderbackendapp.controller.rest.lot.domain.impl;

import com.alexfossa204.crmtenderbackendapp.controller.rest.lot.domain.LotController;
import com.alexfossa204.crmtenderbackendapp.service.lot.domain.LotService;
import com.alexfossa204.crmtenderbackendapp.service.lot.domain.dto.LotDomainModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lots/management")
@Tag(name = "Lot Management API", description = "Данный компонент отвечает за предоставления функционала управления над лотами, зарегистрированными в CRM")
public class LotControllerImpl implements LotController {

    private final LotService lotService;

    @GetMapping("/all")
    @Override
    public ResponseEntity<List<LotDomainModel>> getRequestFindAllLots(@RequestParam Integer pageNumber, @RequestParam Integer elementQuantity) {
        return ResponseEntity.ok(lotService.findAllLots(PageRequest.of(pageNumber, elementQuantity)));
    }
}
