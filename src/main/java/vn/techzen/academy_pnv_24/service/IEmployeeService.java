package vn.techzen.academy_pnv_24.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.techzen.academy_pnv_24.dto.employee.EmployeeSearchRequest;
import vn.techzen.academy_pnv_24.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAttributes(EmployeeSearchRequest employeeSearchRequest, Pageable pageable);
    Optional<Employee> findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);

    List<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest);
}
