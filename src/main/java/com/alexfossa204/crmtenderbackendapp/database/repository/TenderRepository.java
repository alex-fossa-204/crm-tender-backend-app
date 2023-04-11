package com.alexfossa204.crmtenderbackendapp.database.repository;

import com.alexfossa204.crmtenderbackendapp.database.entity.Tender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TenderRepository extends JpaRepository<Tender, Long> {

    Optional<Tender> findByTenderNumber(String tenderNumber);

}
