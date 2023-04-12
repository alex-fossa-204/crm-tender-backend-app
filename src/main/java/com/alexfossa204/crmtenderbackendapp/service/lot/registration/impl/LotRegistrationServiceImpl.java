package com.alexfossa204.crmtenderbackendapp.service.lot.registration.impl;

import com.alexfossa204.crmtenderbackendapp.database.entity.Lot;
import com.alexfossa204.crmtenderbackendapp.database.repository.LotRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.TenderRepository;
import com.alexfossa204.crmtenderbackendapp.service.lot.registration.LotRegistrationService;
import com.alexfossa204.crmtenderbackendapp.service.lot.registration.dto.LotRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.lot.registration.dto.LotRegistrationResponse;
import com.alexfossa204.crmtenderbackendapp.service.lot.registration.mapper.LotEntityToLotRegistrationRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LotRegistrationServiceImpl implements LotRegistrationService {

    private final TenderRepository tenderRepository;

    private final LotRepository lotRepository;

    private final LotEntityToLotRegistrationRequestMapper lotEntityToLotRegistrationRequestMapper;

    @Override
    public LotRegistrationResponse registerNewLot(LotRegistrationRequest lotRegistrationRequest) {
        var tenderNumber = lotRegistrationRequest.getTenderNumber();
        var persistedTender = tenderRepository.findByTenderNumber(tenderNumber)
                .orElseThrow(() -> new RuntimeException(String.format("Tender not found: tenderNumber = %s", tenderNumber)));
        var detachedLot = lotEntityToLotRegistrationRequestMapper.mapLotRegistrationRequestToLotEntity(lotRegistrationRequest);
        detachedLot.setTender(persistedTender);
        return lotEntityToLotRegistrationRequestMapper.mapLotEntityToLotRegistrationResponse(
                lotRepository.save(detachedLot)
        );
    }
}
