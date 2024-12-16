package vn.techzen.academy_pnv_24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.techzen.academy_pnv_24.entity.Employee;
import vn.techzen.academy_pnv_24.entity.Gender;

import java.time.LocalDate;
import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("""
       FROM Employee e
       WHERE (:name IS NULL OR e.name LIKE %:name%)
       AND (:dobFrom IS NULL OR e.dob >= :dobFrom)
       AND (:dobTo IS NULL OR e.dob <= :dobTo)
       AND (:gender IS NULL OR e.gender = :gender)
       AND (:salaryFrom IS NULL OR e.salary >= :salaryFrom)
       AND (:salaryTo IS NULL OR e.salary <= :salaryTo)
       AND (:phone IS NULL OR e.phone LIKE %:phone%)
       AND (:departmentId IS NULL OR e.department.id = :departmentId)
       """)
    List<Employee> findByAttributes(String name,
                                    LocalDate dobFrom,
                                    LocalDate dobTo,
                                    Gender gender,
                                    Double salaryFrom,
                                    Double salaryTo,
                                    String phone,
                                    Integer departmentId);

}
