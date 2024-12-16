package vn.techzen.academy_pnv_24.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv_24.dto.employee.EmployeeSearchRequest;
import vn.techzen.academy_pnv_24.service.IEmployeeService;
import vn.techzen.academy_pnv_24.util.JsonResponse;
import vn.techzen.academy_pnv_24.exception.AppException;
import vn.techzen.academy_pnv_24.exception.ErrorCode;
import vn.techzen.academy_pnv_24.model.Employee;
import vn.techzen.academy_pnv_24.model.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    // list of employees
    IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getEmployees(EmployeeSearchRequest employeeSearchRequest){
        return JsonResponse.ok(employeeService.findByAttributes(employeeSearchRequest));
    }
    // API to get details of a single employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable("id") UUID id) {
        return employeeService.findById(id).map(JsonResponse::ok).orElseThrow(()->new AppException(ErrorCode.EMPLOYEE_NOT_EXIST));
    }
    // API create a new employee
    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        return JsonResponse.created(employeeService.save(employee));
    }
    // API to update an employee
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") UUID id, @RequestBody Employee employee) {
        employeeService.findById(id).orElseThrow(()->new AppException(ErrorCode.EMPLOYEE_NOT_EXIST));
        employee.setId(id);
        return JsonResponse.ok(employeeService.save(employee));
    }
    // API delete an employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") UUID id) {
        employeeService.findById(id).orElseThrow(()->new AppException(ErrorCode.EMPLOYEE_NOT_EXIST));
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}