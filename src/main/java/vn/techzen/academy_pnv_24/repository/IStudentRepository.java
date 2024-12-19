package vn.techzen.academy_pnv_24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.techzen.academy_pnv_24.entity.Student;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    @Query("""
           FROM Student WHERE name like CONCAT ('%',:name,'%') 
           AND (:fromAge IS NULL OR age >= :fromAge)
           AND (:toAge IS NULL OR age <= :toAge)
            """)
    List<Student> findByAge(String name,int fromAge, int toAge);
}
