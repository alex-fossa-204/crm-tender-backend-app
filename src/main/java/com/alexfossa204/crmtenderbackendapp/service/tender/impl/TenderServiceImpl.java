package com.alexfossa204.crmtenderbackendapp.service.tender.impl;

import com.alexfossa204.crmtenderbackendapp.database.entity.Tender;
import com.alexfossa204.crmtenderbackendapp.database.repository.TenderRepository;
import com.alexfossa204.crmtenderbackendapp.service.tender.TenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class TenderServiceImpl implements TenderService {

    private final TenderRepository tenderRepository;

    @Override
    public List<Tender> findAllTenders() {
        return tenderRepository.findAll();
    }

    @Override
    public Tender saveTender(Tender tender) {
        return tenderRepository.save(tender);
    }

    @Override
    public Tender updateTender(Tender tender) {
        return tenderRepository.save(tender);
    }

    @Override
    public void deleteTender(Tender tender) {
        tenderRepository.deleteById(tender.getId());
    }
}
