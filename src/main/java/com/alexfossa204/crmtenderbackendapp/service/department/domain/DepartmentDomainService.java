package com.alexfossa204.crmtenderbackendapp.service.department.domain;

import com.alexfossa204.crmtenderbackendapp.controller.rest.department.dto.DepartmentPageResponse;
import org.springframework.data.domain.PageRequest;

public interface DepartmentDomainService {

    /**
     * Найти все департаменты
     * @return массив менеджеров
     */
    DepartmentPageResponse selectDepartmentPage(PageRequest pageRequest);

}
