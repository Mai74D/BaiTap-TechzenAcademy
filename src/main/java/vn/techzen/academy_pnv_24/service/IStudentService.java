package vn.techzen.academy_pnv_24.service;

import vn.techzen.academy_pnv_24.model.Student;
import vn.techzen.academy_pnv_24.repository.StudentRepository;

import java.util.List;

public interface IStudentService  {
    List<Student> findAllStudents() ;
    Student findStudentById(int id) ;
    Student saveStudent(Student student);
}
