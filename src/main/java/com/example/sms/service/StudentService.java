package com.example.sms.service;

import java.util.List;

import com.example.sms.entity.Student;

public interface StudentService {
	List<Student> getStudentList();
	Student saveStudent(Student student);
	Student findStudentById(Long id);
	void deleteStudent(Long id);
}