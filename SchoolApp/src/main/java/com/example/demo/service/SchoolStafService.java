package com.example.demo.service;

import java.util.List;

import com.example.demo.exceptions.SchoolStafExceptions;
import com.example.demo.model.Student;

public interface SchoolStafService {
	

	public void setStudentStatus(Integer userId, String status) throws SchoolStafExceptions;

	public void setCircular(String circular) throws SchoolStafExceptions;

}
