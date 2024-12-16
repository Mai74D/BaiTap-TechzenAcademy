package vn.techzen.academy_pnv_24.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    LocalDate dob;

    @Enumerated(EnumType.STRING) // Sử dụng kiểu STRING để lưu giá trị enum dưới dạng chuỗi
    Gender gender;

    Double salary;
    String phone;

    @ManyToOne // Liên kết nhiều Employee có thể thuộc một Department
    @JoinColumn(name = "department_id", referencedColumnName = "id") // Liên kết với cột id trong bảng Department
    Department department;
}
