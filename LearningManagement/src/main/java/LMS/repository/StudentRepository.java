package LMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import LMS.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	Student findByEmail(String email);

}
