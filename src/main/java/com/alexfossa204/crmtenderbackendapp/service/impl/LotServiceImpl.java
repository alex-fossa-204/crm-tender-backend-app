package com.alexfossa204.crmtenderbackendapp.service.impl;

import com.alexfossa204.crmtenderbackendapp.database.entity.Lot;
import com.alexfossa204.crmtenderbackendapp.database.repository.LotRepository;
import com.alexfossa204.crmtenderbackendapp.service.LotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class LotServiceImpl implements LotService {

    private final LotRepository lotRepository;

    @Override
    public List<Lot> findAllLots() {
        return lotRepository.findAll();
    }

    @Override
    public Lot saveLot(Lot lot) {
        return lotRepository.save(lot);
    }

    @Override
    public Lot updateLot(Lot lot) {
        return lotRepository.save(lot);
    }

    @Override
    public void deleteLot(Lot lot) {
        lotRepository.deleteById(lot.getId());
    }
}
