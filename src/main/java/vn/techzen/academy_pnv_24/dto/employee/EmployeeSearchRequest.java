package vn.techzen.academy_pnv_24.dto.employee;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import vn.techzen.academy_pnv_24.entity.Gender;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeSearchRequest {
    String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate dobFrom;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate dobTo;
    Gender gender;
    Double salaryFrom;
    Double salaryTo;
    String phone;
    Integer departmentId;
}
