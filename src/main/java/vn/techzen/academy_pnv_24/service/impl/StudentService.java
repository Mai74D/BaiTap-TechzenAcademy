package vn.techzen.academy_pnv_24.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.techzen.academy_pnv_24.entity.Student;
import vn.techzen.academy_pnv_24.repository.IStudentRepository;
import vn.techzen.academy_pnv_24.service.IStudentService;

import java.util.List;
@Service
@AllArgsConstructor
public class StudentService implements IStudentService {
     IStudentRepository studentRepository;


    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public  Student findStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
