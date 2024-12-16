package vn.techzen.academy_pnv_24.repository.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import vn.techzen.academy_pnv_24.dto.employee.EmployeeSearchRequest;
import vn.techzen.academy_pnv_24.model.Employee;
import vn.techzen.academy_pnv_24.model.Gender;
import vn.techzen.academy_pnv_24.repository.IEmployeeRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeRepository implements IEmployeeRepository {
    List<Employee> employees = new ArrayList<>(
            Arrays.asList(
                    new Employee(UUID.randomUUID(), "Nguyễn Văn A", LocalDate.of(1990, 1, 1), Gender.MALE, 10000.0, "0123456789", UUID.randomUUID().toString()),
                    new Employee(UUID.randomUUID(),"Trần Thị B",LocalDate.of(1992, 2, 2),Gender.FEMALE,12000.0,"0987654321",UUID.randomUUID().toString()),
                    new Employee(UUID.randomUUID(),"Lê Văn C",LocalDate.of(1995, 3, 3),Gender.MALE,15000.0,"0123456789",UUID.randomUUID().toString()),
                    new Employee(UUID.randomUUID(),"Nguyễn Thị D",LocalDate.of(1998, 4, 4),Gender.FEMALE,18000.0,"0987654321",UUID.randomUUID().toString()),
                    new Employee(UUID.randomUUID(),"Trần Văn E",LocalDate.of(2000, 5, 5),Gender.MALE,20000.0,"0123456789",UUID.randomUUID().toString()),
                    new Employee(UUID.randomUUID(),"Lê Thị F",LocalDate.of(2002, 6, 6),Gender.FEMALE,22000.0,"0987654321",UUID.randomUUID().toString()),
                    new Employee(UUID.randomUUID(),"Nguyễn Văn G",LocalDate.of(2005, 7, 7),Gender.MALE,25000.0,"0123456789",UUID.randomUUID().toString()),
                    new Employee(UUID.randomUUID(),"Trần Thị H", LocalDate.of(2008, 8, 8), Gender.FEMALE, 28000.0, "0987654321", UUID.randomUUID().toString()),
                    new Employee(UUID.randomUUID(),"Lê Văn I",LocalDate.of(2010, 9, 9),Gender.MALE,30000.0,"0123456789",UUID.randomUUID().toString()),
                    new Employee(UUID.randomUUID(),"Nguyễn Thị J",LocalDate.of(2012, 10, 10),Gender.FEMALE,32000.0,"0987654321",UUID.randomUUID().toString())
            ));

    @Override
    public List<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest){
        return employees.stream()
                .filter(e->(employeeSearchRequest.getName() == null || e.getName().toLowerCase()
                        .contains(employeeSearchRequest.getName().toLowerCase())))
                        .collect(Collectors.toList());
    }

    @Override
    public Optional<Employee> findById(UUID id) {
        return employees.stream().filter(e->(e.getId().equals(id))).findFirst();
    }


    @Override
    public void deleteById(UUID id) {
        findById(id).ifPresent(employees::remove);
    }

    @Override
    public Employee save(Employee employee){
        return findById(employee.getId())
                .map(
                        e->{
                            e.setName(employee.getName());
                            e.setDob(employee.getDob());
                            e.setGender(employee.getGender());
                            e.setSalary(employee.getSalary());
                            e.setPhone(employee.getPhone());
                            e.setDepartmentId(employee.getDepartmentId());
                            return e;
                        }).orElseGet(()->{
                            employee.setId(UUID.randomUUID());
                            employees.add(employee);
                            return employee;
                        });
    }

}
