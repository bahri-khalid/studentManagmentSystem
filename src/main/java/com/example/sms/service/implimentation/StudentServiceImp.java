package com.example.sms.service.implimentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;
import com.example.sms.service.StudentService;

@Service
public class StudentServiceImp implements StudentService {

	private StudentRepository studentRepository;
	
	@Autowired
	public void setStudentRepository(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public StudentServiceImp() {
		super();
	}

	@Override
	public String toString() {
		return "StudentServiceImp [studentRepository=" + studentRepository + "]";
	}

	public StudentServiceImp(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	public StudentRepository getStudentRepository() {
		return studentRepository;
	}
	
	

	@Override
	public List<Student> getStudentList() {
		
		return studentRepository.findAll();
	}

}
