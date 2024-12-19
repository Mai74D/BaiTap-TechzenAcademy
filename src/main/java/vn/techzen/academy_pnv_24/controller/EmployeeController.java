package vn.techzen.academy_pnv_24.controller;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import vn.techzen.academy_pnv_24.dto.page.PageResponse;
import vn.techzen.academy_pnv_24.dto.employee.EmployeeSearchRequest;
import vn.techzen.academy_pnv_24.service.IEmployeeService;
import vn.techzen.academy_pnv_24.util.JsonResponse;
import vn.techzen.academy_pnv_24.exception.AppException;
import vn.techzen.academy_pnv_24.exception.ErrorCode;
import vn.techzen.academy_pnv_24.entity.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // List employees with pagination
    @GetMapping
    public ResponseEntity<?> getEmployees(EmployeeSearchRequest employeeSearchRequest,
                                          @PageableDefault(size = 10, sort = "id"
                                          , direction = Sort.Direction.ASC) Pageable pageable) {
        // Use the service to get paginated results
        return JsonResponse.ok(new PageResponse<>(employeeService.findAttributes(employeeSearchRequest, pageable)));
    }



    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable("id") int id) {
        return employeeService.findById(id)
                .map(JsonResponse::ok)
                .orElseThrow(() -> new AppException(ErrorCode.EMPLOYEE_NOT_EXIST));
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        return JsonResponse.created(employeeService.save(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        employeeService.findById(id).orElseThrow(() -> new AppException(ErrorCode.EMPLOYEE_NOT_EXIST));
        employee.setId(id);
        return JsonResponse.ok(employeeService.save(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {
        employeeService.findById(id).orElseThrow(() -> new AppException(ErrorCode.EMPLOYEE_NOT_EXIST));
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
