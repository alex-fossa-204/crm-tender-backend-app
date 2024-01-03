package com.alexfossa204.crmtenderbackendapp.controller.rest.customer;

import com.alexfossa204.crmtenderbackendapp.controller.rest.customer.dto.CustomerPageResponse;
import com.alexfossa204.crmtenderbackendapp.service.customer.domain.CustomerDomainService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
@Tag(name = "Customer Management API", description = "Данный компонент отвечает за предоставление функционала управления над заказчиками, зарегистрированными в CRM")
public class CustomerController {

    private final CustomerDomainService customerDomainService;

    /**
     * REST:GET запрос на получении данных обо всех менеджерах
     * @return массив объектов
     */
    @GetMapping("/page")
    public ResponseEntity<CustomerPageResponse> getRequestFindAllManager(@RequestParam Integer id, @RequestParam Integer items) {
        return ResponseEntity.ok(
                customerDomainService.selectCustomerPage(PageRequest.of(id, items))
        );
    }

}
