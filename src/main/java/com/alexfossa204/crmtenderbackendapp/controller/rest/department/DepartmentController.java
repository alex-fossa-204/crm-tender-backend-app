package com.alexfossa204.crmtenderbackendapp.controller.rest.department;


import com.alexfossa204.crmtenderbackendapp.controller.rest.department.dto.DepartmentPageResponse;
import com.alexfossa204.crmtenderbackendapp.controller.rest.department.dto.DepartmentResponse;
import com.alexfossa204.crmtenderbackendapp.service.department.domain.DepartmentDomainService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/departments")
@Tag(name = "Department Management API", description = "Данный компонент отвечает за предоставление функционала управления над департаментами, зарегистрированными в CRM")
public class DepartmentController {

    private final DepartmentDomainService departmentDomainService;

    @GetMapping("/page")
    public ResponseEntity<DepartmentPageResponse> getRequestFindAllDepartments(@RequestParam Integer id, @RequestParam Integer items) {
        return ResponseEntity.ok(
                departmentDomainService.selectDepartmentPage(PageRequest.of(id, items))
        );
    }

    @PostMapping("/{id}")
    public ResponseEntity<DepartmentResponse> getDepartmentByPublicId(@PathVariable String id) {
        return ResponseEntity.ok(departmentDomainService.findDepartmentByPublicId(id));
    }

}
