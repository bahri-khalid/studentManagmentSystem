package com.example.sms.controller;

import java.util.List;

import javax.persistence.PostUpdate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;

@Controller
public class StudentController {
	private StudentService studentService;

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	@GetMapping("/students")
	public String getStudents(Model model) {
		System.out.println(studentService.getStudentList());
		model.addAttribute("students",studentService.getStudentList());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String newStudent(Model model) {
		model.addAttribute("student",new Student());
		return "newStudent";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
//		System.out.println(student.toString());
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id,Model model) {
		model.addAttribute("student",studentService.findStudentById(id));
		return "editStudent";
	}
	
	@PostMapping("/students/{id}")
	public String saveChangeStudent(@ModelAttribute("student") Student student,@PathVariable Long id) {
		Student changedStudent = studentService.findStudentById(id);
		changedStudent.setFirstName(student.getFirstName());
		changedStudent.setLastName(student.getLastName());
		changedStudent.setEmail(student.getEmail());
		studentService.saveStudent(changedStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
}
