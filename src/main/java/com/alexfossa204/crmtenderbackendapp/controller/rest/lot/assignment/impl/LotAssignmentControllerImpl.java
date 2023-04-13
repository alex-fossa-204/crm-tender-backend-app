package com.alexfossa204.crmtenderbackendapp.controller.rest.lot.assignment.impl;

import com.alexfossa204.crmtenderbackendapp.controller.rest.lot.assignment.LotAssignmentController;
import com.alexfossa204.crmtenderbackendapp.service.lot.assigning.LotAssigningService;
import com.alexfossa204.crmtenderbackendapp.service.lot.assigning.dto.LotAssigningRequest;
import com.alexfossa204.crmtenderbackendapp.service.lot.assigning.dto.LotAssigningResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lot/assignment")
@Tag(name = "Lot Management API", description = "Данный компонент отвечает за предоставления функционала управления над лотами, зарегистрированными в CRM")
public class LotAssignmentControllerImpl implements LotAssignmentController {

    private final LotAssigningService lotAssigningService;

    @PostMapping("employee")
    @Override
    public ResponseEntity<LotAssigningResponse> postRequestAssignLotToEmployee(@RequestBody LotAssigningRequest lotAssigningRequest) {
        return ResponseEntity.ok(lotAssigningService.assignLotToEmployee(lotAssigningRequest));
    }
}
