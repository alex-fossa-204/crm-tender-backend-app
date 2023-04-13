package com.alexfossa204.crmtenderbackendapp.controller.rest.tender.domain.impl;

import com.alexfossa204.crmtenderbackendapp.controller.rest.tender.domain.TenderController;
import com.alexfossa204.crmtenderbackendapp.service.tender.domain.TenderService;
import com.alexfossa204.crmtenderbackendapp.service.tender.domain.dto.TenderDomainModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tenders/management")
@Tag(name = "Tender Management API", description = "Данный компонент отвечает за предоставление функционала по управлению данными тендеров")
public class TenderControllerImpl  implements TenderController {

    private final TenderService tenderService;

    @GetMapping("/all")
    @Override
    public ResponseEntity<List<TenderDomainModel>> getRequestFindAllTenders(@RequestParam Integer pageNumber, @RequestParam Integer elementQuantity) {
        return ResponseEntity.ok(tenderService.findAllTenders(PageRequest.of(pageNumber, elementQuantity)));
    }
}
