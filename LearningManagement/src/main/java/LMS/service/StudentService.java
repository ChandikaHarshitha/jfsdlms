package LMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LMS.model.Student;
import LMS.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	public Student registerStudent(Student student) {
		return studentRepository.save(student);
	}
	public Student findStudentByEmail(String email) {
		return studentRepository.findByEmail(email);
	}

}
