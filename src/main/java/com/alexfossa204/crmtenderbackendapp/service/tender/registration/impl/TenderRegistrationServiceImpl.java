package com.alexfossa204.crmtenderbackendapp.service.tender.registration.impl;

import com.alexfossa204.crmtenderbackendapp.database.repository.TenderRepository;
import com.alexfossa204.crmtenderbackendapp.service.tender.registration.TenderRegistrationService;
import com.alexfossa204.crmtenderbackendapp.service.tender.registration.dto.TenderRegistrationRequest;
import com.alexfossa204.crmtenderbackendapp.service.tender.registration.dto.TenderRegistrationResponse;
import com.alexfossa204.crmtenderbackendapp.service.tender.registration.mapper.TenderEntityToTenderRegistrationRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TenderRegistrationServiceImpl implements TenderRegistrationService {

    private final TenderEntityToTenderRegistrationRequestMapper tenderEntityToTenderRegistrationRequestMapper;
    private final TenderRepository tenderRepository;


    @Override
    public TenderRegistrationResponse registerNewTender(TenderRegistrationRequest tenderRegistrationRequest) {
        var tenderNumber = tenderRegistrationRequest.getName();
        var tenderOptional = tenderRepository.findByTenderUuid(tenderNumber);
        if (tenderOptional.isPresent()) {
            throw new RuntimeException(String.format("Тендер уже зарегистрирован в системе: tenderNumber = %s ", tenderNumber));
        }

        var detachedTender = tenderEntityToTenderRegistrationRequestMapper.mapTenderRegistrationRequestToTenderEntity(tenderRegistrationRequest);

        var persistedTender = tenderRepository.save(detachedTender);

        return tenderEntityToTenderRegistrationRequestMapper.mapTenderEntityToTenderRegistrationResponse(persistedTender);
    }

    //TODO создать исключение на случай попытке сохранить тендер с указанным номером tenderNumber
}
