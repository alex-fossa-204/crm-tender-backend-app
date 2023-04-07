package com.alexfossa204.crmtenderbackendapp.controller.graphql;

import com.alexfossa204.crmtenderbackendapp.controller.graphql.model.EmployeeTO;
import com.alexfossa204.crmtenderbackendapp.database.entity.Employee;
import com.alexfossa204.crmtenderbackendapp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

//@RequiredArgsConstructor
//@Slf4j
//@Controller
public class EmployeeControllerGraphQL {

//    private final EmployeeService employeeService;

//    @QueryMapping
//    public List<EmployeeTO> findAllEmployees() {
//        return List.of(
//                EmployeeTO.builder()
//                        .setFirstname("Alex")
//                        .setLastname("Smirnov")
//                        .build(),
//                EmployeeTO.builder()
//                        .setFirstname("Ivan")
//                        .setLastname("Vanov")
//                        .build()
//        );
//    }

}
