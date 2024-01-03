package com.alexfossa204.crmtenderbackendapp.service.tender.domain.impl;

import com.alexfossa204.crmtenderbackendapp.controller.rest.tender.dto.TenderPageResponse;
import com.alexfossa204.crmtenderbackendapp.database.repository.TenderRepository;
import com.alexfossa204.crmtenderbackendapp.service.tender.domain.TenderDomainService;
import com.alexfossa204.crmtenderbackendapp.service.tender.domain.dto.TenderDomainModel;
import com.alexfossa204.crmtenderbackendapp.service.tender.domain.mapper.TenderToTenderDomainModelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
public class TenderDomainServiceImpl implements TenderDomainService {

    private final TenderToTenderDomainModelMapper tenderToTenderDomainModelMapper;

    private final TenderRepository tenderRepository;

    @Transactional
    @Override
    public TenderPageResponse selectTenderPage(PageRequest pageRequest) {
        return TenderPageResponse.of(
                tenderRepository.count(),
                tenderRepository.findAll(pageRequest).getContent()
                        .stream()
                        .map(tenderToTenderDomainModelMapper::mapTenderEntityToTenderDomainModel)
                        .toList()

        );
    }

    @Override
    public TenderDomainModel updateTender(TenderDomainModel tender) {
        throw new NotImplementedException("Method is not implemented");
    }

    @Override
    public void deleteTender(TenderDomainModel tender) {
        throw new NotImplementedException("Method is not implemented");
    }
}
