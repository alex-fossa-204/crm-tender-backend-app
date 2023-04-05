package com.alexfossa204.crmtenderbackendapp.database.repository;

import com.alexfossa204.crmtenderbackendapp.database.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, UUID> {

}
