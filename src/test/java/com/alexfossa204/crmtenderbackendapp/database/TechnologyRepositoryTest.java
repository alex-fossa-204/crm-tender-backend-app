package com.alexfossa204.crmtenderbackendapp.database;

import com.alexfossa204.crmtenderbackendapp.database.entity.Technology;
import com.alexfossa204.crmtenderbackendapp.database.repository.TechnologyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
public class TechnologyRepositoryTest {

    @Autowired
    private TechnologyRepository technologyRepository;

    @Test
    void when_findAll_technologies() {
        List<Technology> technologyList = technologyRepository.findAll();

        assertAll("Проверка сохранения тестовой записи",
                () -> assertThat(technologyList, is(notNullValue()))
        );
    }

}
