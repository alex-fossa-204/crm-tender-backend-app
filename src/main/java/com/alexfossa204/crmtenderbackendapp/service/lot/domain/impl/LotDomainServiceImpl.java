package com.alexfossa204.crmtenderbackendapp.service.lot.domain.impl;

import com.alexfossa204.crmtenderbackendapp.controller.rest.base.dto.delete.BaseDeleteResponse;
import com.alexfossa204.crmtenderbackendapp.service.lot.domain.dto.LotDomainModel;
import com.alexfossa204.crmtenderbackendapp.database.repository.LotRepository;
import com.alexfossa204.crmtenderbackendapp.service.lot.domain.LotDomainService;
import com.alexfossa204.crmtenderbackendapp.service.lot.domain.mapper.LotToLotDomainModelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class LotDomainServiceImpl implements LotDomainService {

    private final LotRepository lotRepository;

    private final LotToLotDomainModelMapper lotToLotDomainModelMapper;

    @Override
    public List<LotDomainModel> findAllLots(PageRequest pageRequest) {
        return lotRepository.findAll(pageRequest).getContent()
                .stream()
                .map(lotToLotDomainModelMapper::mapLotEntityToLotDomainModel)
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

    @Transactional
    @Override
    public BaseDeleteResponse deleteLot(String lotUuid) {
        val currentLot = lotRepository.findByLotUuid(
                UUID.fromString(lotUuid)
        ).orElseThrow(() -> new RuntimeException(String.format("Лот с uuid = %s - не найден", lotUuid)));
        lotRepository.deleteById(currentLot.getId());
        return BaseDeleteResponse.of(
                lotUuid,
                String.format("Лот с uuid = %s - удален успешно", lotUuid)
        );
    }
}
