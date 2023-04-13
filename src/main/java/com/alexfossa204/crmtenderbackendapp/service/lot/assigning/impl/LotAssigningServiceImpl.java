package com.alexfossa204.crmtenderbackendapp.service.lot.assigning.impl;

import com.alexfossa204.crmtenderbackendapp.database.entity.employee_lot.EmployeeLot;
import com.alexfossa204.crmtenderbackendapp.database.entity.employee_lot.key.EmployeeLotKey;
import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeLotRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.EmployeeRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.LotRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.ManagerRepository;
import com.alexfossa204.crmtenderbackendapp.service.lot.assigning.LotAssigningService;
import com.alexfossa204.crmtenderbackendapp.service.lot.assigning.dto.LotAssigningRequest;
import com.alexfossa204.crmtenderbackendapp.service.lot.assigning.dto.LotAssigningResponse;
import com.alexfossa204.crmtenderbackendapp.service.lot.assigning.mapper.LotAssigningMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.alexfossa204.crmtenderbackendapp.database.entity.employee_lot.state.EmployeeLotState.АКТИВНЫЙ;

@RequiredArgsConstructor
@Service
public class LotAssigningServiceImpl implements LotAssigningService {

    private final EmployeeRepository employeeRepository;

    private final LotRepository lotRepository;

    private final ManagerRepository managerRepository;

    private final EmployeeLotRepository employeeLotRepository;

    private final LotAssigningMapper lotAssigningMapper;


    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    @Override
    public LotAssigningResponse assignLotToEmployee(LotAssigningRequest lotAssigningRequest) {
        var employeeUuid = lotAssigningRequest.getManagerUuid();
        var persistedEmployee = employeeRepository.findByEmployeeUuid(lotAssigningRequest.getEmployeeUuid())
                .orElseThrow(() -> new RuntimeException(String.format("Сотрудник не найден: employeeUuid = %s", employeeUuid)));

        var lotUuid = lotAssigningRequest.getLotUuid();
        var persistedLot = lotRepository.findByLotUuid(lotAssigningRequest.getLotUuid())
                .orElseThrow(() -> new RuntimeException(String.format("Лот не найден: lotUuid = %s", lotUuid)));

        var managerUuid = lotAssigningRequest.getManagerUuid();
        var persistedManager = managerRepository.findByManagerUuid(managerUuid)
                .orElseThrow(() -> new RuntimeException(String.format("Менеджер не найден: managerUuid = %s", managerUuid)));

        LocalDateTime lotAssignmentTimestamp = LocalDateTime.now();
        return lotAssigningMapper.mapEmployeeLotEntityToLotAssigningResponse(
                employeeLotRepository.save(
                        EmployeeLot.of(
                                EmployeeLotKey.of(persistedEmployee.getId(), persistedLot.getId()),
                                persistedEmployee,
                                persistedLot,
                                persistedManager,
                                АКТИВНЫЙ,
                                lotAssignmentTimestamp,
                                lotAssignmentTimestamp
                        )
                )
        );
    }
}
