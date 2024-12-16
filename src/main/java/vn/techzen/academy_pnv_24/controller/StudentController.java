package vn.techzen.academy_pnv_24.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv_24.dto.ApiResponse;
import vn.techzen.academy_pnv_24.exception.AppException;
import vn.techzen.academy_pnv_24.exception.ErrorCode;
import vn.techzen.academy_pnv_24.entity.Student;
import vn.techzen.academy_pnv_24.service.impl.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService ;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @RequestMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable int id) throws AppException {
        Student student = studentService.findStudentById(id);
        if (student == null) {
            throw new AppException(ErrorCode.STUDENT_NOT_EXIST);
        }
        return ResponseEntity.ok(ApiResponse.<Student>builder()
                .data(student)
                .build()
        );
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}
