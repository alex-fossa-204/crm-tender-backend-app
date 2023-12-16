package com.alexfossa204.crmtenderbackendapp.controller.rest.employee.dto;

import com.alexfossa204.crmtenderbackendapp.service.manager.domain.dto.ManagerDomainModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor(staticName = "of")
@Data
public class EmployeePageResponse {

    private Long total;

    private List<ManagerDomainModel> managers;

}
