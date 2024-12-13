package vn.techzen.academy_pnv_24.service;

import vn.techzen.academy_pnv_24.model.Student;
import vn.techzen.academy_pnv_24.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService{
    private IStudentService studentRepository;


    public List<Student> findAllStudents() {
        return studentRepository.findAllStudents();
    }

    public  Student findStudentById(int id) {
        return studentRepository.findStudentById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.saveStudent(student);
    }
}
