package vn.techzen.academy_pnv_24.repository;

import vn.techzen.academy_pnv_24.dto.employee.EmployeeSearchRequest;
import vn.techzen.academy_pnv_24.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IEmployeeRepository {
    List<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest);
    Optional<Employee> findById(UUID id);
    Employee save(Employee employee);
    void deleteById(UUID id);
}
