package vn.techzen.academy_pnv_24.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import vn.techzen.academy_pnv_24.dto.employee.EmployeeSearchRequest;
import vn.techzen.academy_pnv_24.model.Employee;
import vn.techzen.academy_pnv_24.repository.IEmployeeRepository;
import vn.techzen.academy_pnv_24.service.IEmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAttributes(EmployeeSearchRequest employeeSearchRequest) {
        return employeeRepository.findByAttributes(employeeSearchRequest);
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(UUID id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest) {
        return List.of();
    }


}
