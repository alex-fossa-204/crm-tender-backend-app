package com.alexfossa204.crmtenderbackendapp.service.tender.domain.impl;

import com.alexfossa204.crmtenderbackendapp.database.repository.TenderRepository;
import com.alexfossa204.crmtenderbackendapp.service.tender.domain.TenderEntityToTenderDomainModelMapper;
import com.alexfossa204.crmtenderbackendapp.service.tender.domain.TenderService;
import com.alexfossa204.crmtenderbackendapp.service.tender.domain.dto.TenderDomainModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class TenderServiceImpl implements TenderService {

    private final TenderEntityToTenderDomainModelMapper tenderEntityToTenderDomainModelMapper;

    private final TenderRepository tenderRepository;

    @Override
    public List<TenderDomainModel> findAllTenders(PageRequest pageRequest) {
        return tenderRepository.findAll(pageRequest).getContent()
                .stream()
                .map(tenderEntityToTenderDomainModelMapper::mapTenderEntityToTenderDomainModel)
                .toList();
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
