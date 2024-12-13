package vn.techzen.academy_pnv_24.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import vn.techzen.academy_pnv_24.dto.ApiResponse;
import vn.techzen.academy_pnv_24.exeption.AppExeption;
import vn.techzen.academy_pnv_24.exeption.ErrorCode;
import vn.techzen.academy_pnv_24.model.Student;
import vn.techzen.academy_pnv_24.service.StudentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.DoubleStream.builder;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final RestClient.Builder builder;
    private StudentService studentService = new StudentService();

    public StudentController(RestClient.Builder builder) {
        this.builder = builder;
    }

    @RequestMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable int id) throws AppExeption {
        Student student = studentService.findStudentById(id);
        if (student == null) {
            throw new AppExeption(ErrorCode.STUDENT_NOT_EXIST);
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
