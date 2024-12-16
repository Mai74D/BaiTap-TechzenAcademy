package vn.techzen.academy_pnv_24.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    // Constructor injection for the service
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // List employees based on search criteria
    @GetMapping
    public ResponseEntity<?> getEmployees(EmployeeSearchRequest employeeSearchRequest) {
        // Use the findAttributes method to get employees based on search criteria
        return JsonResponse.ok(employeeService.findAttributes(employeeSearchRequest));
    }

    // Get details of a single employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable("id") int id) {
        return employeeService.findById(id)
                .map(JsonResponse::ok)
                .orElseThrow(() -> new AppException(ErrorCode.EMPLOYEE_NOT_EXIST));
    }

    // Create a new employee
    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        return JsonResponse.created(employeeService.save(employee));
    }

    // Update an existing employee
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        employeeService.findById(id).orElseThrow(() -> new AppException(ErrorCode.EMPLOYEE_NOT_EXIST));
        employee.setId(id);
        return JsonResponse.ok(employeeService.save(employee));
    }

    // Delete an employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {
        employeeService.findById(id).orElseThrow(() -> new AppException(ErrorCode.EMPLOYEE_NOT_EXIST));
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
