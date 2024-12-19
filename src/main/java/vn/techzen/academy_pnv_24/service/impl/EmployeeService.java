package vn.techzen.academy_pnv_24.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.techzen.academy_pnv_24.dto.employee.EmployeeSearchRequest;
import vn.techzen.academy_pnv_24.entity.Employee;
import vn.techzen.academy_pnv_24.entity.Gender;
import vn.techzen.academy_pnv_24.repository.IEmployeeRepository;
import vn.techzen.academy_pnv_24.service.IEmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAttributes(EmployeeSearchRequest employeeSearchRequest, Pageable pageable) {
        // Retrieve search request parameters
        String name = employeeSearchRequest.getName();
        LocalDate dobFrom = employeeSearchRequest.getDobFrom();
        LocalDate dobTo = employeeSearchRequest.getDobTo();
        Gender gender = employeeSearchRequest.getGender();
        Double salaryFrom = employeeSearchRequest.getSalaryFrom();
        Double salaryTo = employeeSearchRequest.getSalaryTo();
        String phone = employeeSearchRequest.getPhone();
        Integer departmentId = employeeSearchRequest.getDepartmentId();

        // Call repository method with pagination
        return employeeRepository.findByAttributes(
                name, dobFrom, dobTo, gender, salaryFrom, salaryTo, phone, departmentId, pageable);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

}