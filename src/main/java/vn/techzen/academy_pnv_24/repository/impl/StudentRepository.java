package vn.techzen.academy_pnv_24.repository.impl;

import vn.techzen.academy_pnv_24.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentRepository {
    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1,"Ho Thi Mai",18),
                    new Student(2,"Ho Thi Bao",19),
                    new Student(3,"Ho Thi Tan",18),
                    new Student(4,"Ho Thi Duc",18)

            )
    );

    public List<Student> findAllStudents() {
        return students;
    }

    public  Student findStudentById(int id) {
        for (Student student : students) {
            if(student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Student saveStudent(Student student) {
        student.setId((int)(Math.random()*10000));
        students.add(student);
        return student;
    }
}
