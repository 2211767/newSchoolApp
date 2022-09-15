package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.exceptions.SchoolStafExceptions;
import com.example.demo.exceptions.StudentExceptions;
import com.example.demo.model.Student;
import com.example.demo.model.UserApplication;

public interface StudentService {

	public UserApplication save(UserApplication student,String username1) throws StudentExceptions;

	public void updateStudent(UserApplication userApplication) throws StudentExceptions;

	public  UserApplication findByName(String email) throws StudentExceptions;

	public void acknowldgeStatus(Integer circularId, String acknowldgeStatus) throws StudentExceptions;
 
	public List<Student> findAll() throws StudentExceptions;
}
