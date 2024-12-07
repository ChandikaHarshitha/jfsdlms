package LMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import LMS.model.Student;
import LMS.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@PostMapping("/register")
	 public String registerStudent(@ModelAttribute Student student) {
		 studentService.registerStudent(student);
		return "redirect:/login";
	}
	

    @PostMapping("/login")
    public String login(@ModelAttribute Student student) {
        Student existingStudent = studentService.findStudentByEmail(student.getEmail());
        if (existingStudent != null && existingStudent.getPassword().equals(student.getPassword())) {
            return "redirect:/"; // Redirect to home if login is successful
        }
        return "redirect:/login"; // Redirect back to login on failure
    }
}