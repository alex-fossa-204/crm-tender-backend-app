package com.alexfossa204.crmtenderbackendapp.service.tender.domain.impl;

import com.alexfossa204.crmtenderbackendapp.controller.rest.tender.dto.TenderPageResponse;
import com.alexfossa204.crmtenderbackendapp.database.repository.TenderRepository;
import com.alexfossa204.crmtenderbackendapp.service.tender.domain.TenderDomainService;
import com.alexfossa204.crmtenderbackendapp.service.tender.domain.dto.TenderDomainModel;
import com.alexfossa204.crmtenderbackendapp.service.tender.domain.mapper.TenderEntityToTenderDomainModelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class TenderDomainServiceImpl implements TenderDomainService {

    private final TenderEntityToTenderDomainModelMapper tenderEntityToTenderDomainModelMapper;

    private final TenderRepository tenderRepository;

    @Override
    public TenderPageResponse selectTenderPage(PageRequest pageRequest) {
        return TenderPageResponse.of(
                tenderRepository.count(),
                tenderRepository.findAll(pageRequest).getContent()
                        .stream()
                        .map(tenderEntityToTenderDomainModelMapper::mapTenderEntityToTenderDomainModel)
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
