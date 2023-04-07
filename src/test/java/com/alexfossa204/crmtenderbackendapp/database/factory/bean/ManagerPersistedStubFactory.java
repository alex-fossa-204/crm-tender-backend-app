package com.alexfossa204.crmtenderbackendapp.database.factory.bean;

import com.alexfossa204.crmtenderbackendapp.database.entity.Manager;
import com.alexfossa204.crmtenderbackendapp.database.entity.Role;
import com.alexfossa204.crmtenderbackendapp.database.factory.ManagerStubFactory;
import com.alexfossa204.crmtenderbackendapp.database.repository.ManagerRepository;
import com.alexfossa204.crmtenderbackendapp.database.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManagerPersistedStubFactory {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Manager supplyPersistedManagerWithRoleStub() {
        Role role = roleRepository.findAll().stream().findFirst().orElseThrow(() -> new RuntimeException("No value present"));
        return managerRepository.save(ManagerStubFactory.supplyManagerDefaultStub(role));
    }

}
