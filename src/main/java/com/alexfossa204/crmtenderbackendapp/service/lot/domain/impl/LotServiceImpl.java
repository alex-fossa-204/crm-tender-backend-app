package com.alexfossa204.crmtenderbackendapp.service.lot.domain.impl;

import com.alexfossa204.crmtenderbackendapp.database.repository.LotRepository;
import com.alexfossa204.crmtenderbackendapp.service.lot.domain.LotService;
import com.alexfossa204.crmtenderbackendapp.service.lot.domain.dto.LotDomainModel;
import com.alexfossa204.crmtenderbackendapp.service.lot.domain.mapper.LotEntityToLotDomainModelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class LotServiceImpl implements LotService {

    private final LotRepository lotRepository;

    private final LotEntityToLotDomainModelMapper lotEntityToLotDomainModelMapper;

    @Override
    public List<LotDomainModel> findAllLots(PageRequest pageRequest) {
        return lotRepository.findAll(pageRequest).getContent()
                .stream()
                .map(lotEntityToLotDomainModelMapper::mapLotEntityToLotDomainModel)
                .toList();
    }

    @Override
    public LotDomainModel saveLot(LotDomainModel lot) {
        throw new NotImplementedException("Метод в стадии разработки");
    }

    @Override
    public LotDomainModel updateLot(LotDomainModel lot) {
        throw new NotImplementedException("Метод в стадии разработки");
    }

    @Override
    public void deleteLot(LotDomainModel lot) {
        throw new NotImplementedException("Метод в стадии разработки");
    }
}
