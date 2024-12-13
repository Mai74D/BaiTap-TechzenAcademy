package vn.techzen.academy_pnv_24.repository;

import vn.techzen.academy_pnv_24.model.Student;

import java.util.List;

public interface IStudentRepository {

    List<Student> findAllStudents();

    Student findStudentById(int id);

    Student saveStudent(Student student);
}
