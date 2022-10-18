package com.example.sms.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		List <Student> students = studentService.getStudentList();
		System.out.println(students);
		model.addAttribute("students",studentService.getStudentList());
		return "students";
	}
	
	
}
