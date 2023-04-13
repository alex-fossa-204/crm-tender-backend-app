package com.alexfossa204.crmtenderbackendapp.controller.rest.lot.assignment;

import com.alexfossa204.crmtenderbackendapp.service.lot.assigning.dto.LotAssigningRequest;
import com.alexfossa204.crmtenderbackendapp.service.lot.assigning.dto.LotAssigningResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Компонент, предназначенный для обработки HTTP запросов по назначению лотов сотрудникам и менеджерам в системе
 */
public interface LotAssignmentController {

    ResponseEntity<LotAssigningResponse> postRequestAssignLotToEmployee(@RequestBody LotAssigningRequest lotAssigningRequest);

}
