package vn.techzen.academy_pnv_24.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv_24.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1,"Ho Thi Mai",18),
                    new Student(2,"Ho Thi Bao",19),
                    new Student(3,"Ho Thi Tan",18),
                    new Student(4,"Ho Thi Duc",18)

            )
    );

    @RequestMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        for (Student student : students) {
            if(student.getId() == id){
                return ResponseEntity.ok(student);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        student.setId((int) (Math.random()*10000));
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}
