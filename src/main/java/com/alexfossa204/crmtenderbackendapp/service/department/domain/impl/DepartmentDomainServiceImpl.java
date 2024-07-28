package com.alexfossa204.crmtenderbackendapp.service.department.domain.impl;

import com.alexfossa204.crmtenderbackendapp.controller.rest.department.dto.DepartmentPageResponse;
import com.alexfossa204.crmtenderbackendapp.database.repository.DepartmentRepository;
import com.alexfossa204.crmtenderbackendapp.service.department.domain.DepartmentDomainService;
import com.alexfossa204.crmtenderbackendapp.service.department.domain.mapper.DepartmentToDepartmentDomainModelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class DepartmentDomainServiceImpl implements DepartmentDomainService {

    private final DepartmentToDepartmentDomainModelMapper departmentDomainModel;

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentPageResponse selectDepartmentPage(PageRequest pageRequest) {
        return DepartmentPageResponse.of(
                departmentRepository.count(),
                departmentRepository.findAll(pageRequest).getContent()
                        .stream()
                        .map(departmentDomainModel::mapDepartmentToDepartmentDomainModel)
                        .collect(Collectors.toList())
        );
    }

}
