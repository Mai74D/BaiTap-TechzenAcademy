package vn.techzen.academy_pnv_24.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv_24.model.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employees = new ArrayList<>(
            Arrays.asList(
                    new Employee(1, "Hồ Thị Mái", LocalDate.of(2004, 6, 10), "Nữ", new BigDecimal("15000000.0"), "0333982406"),
                    new Employee(2, "Nguyễn Văn An", LocalDate.of(1998, 9, 15), "Nam", new BigDecimal("12000000.0"), "0987654321"),
                    new Employee(3, "Trần Thị Bích", LocalDate.of(1995, 3, 8), "Nữ", new BigDecimal("18000000.0"), "0123456789")
            )
    );

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee request) {
        request.setId((int) (Math.random() * 10000)); // Set a random ID for the new employee
        employees.add(request);
        return ResponseEntity.ok(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee request) {
        Employee existingEmployee = employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);

        if (existingEmployee == null) {
            return ResponseEntity.notFound().build();
        }

        existingEmployee.setName(request.getName());
        existingEmployee.setDob(request.getDob());
        existingEmployee.setGender(request.getGender());
        existingEmployee.setSalary(request.getSalary());
        existingEmployee.setPhone(request.getPhone());

        return ResponseEntity.ok(existingEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {
        Employee existingEmployee = employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);

        if (existingEmployee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee not found.");
        }
        employees.remove(existingEmployee);

        return ResponseEntity.ok("Employee with ID " + id + " has been deleted successfully.");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") int id) {
        Employee existingEmployee = employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);

        if (existingEmployee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee not found.");
        }

        return ResponseEntity.ok(existingEmployee);
    }

}
