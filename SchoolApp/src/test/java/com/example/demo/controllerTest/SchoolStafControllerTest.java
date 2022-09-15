package com.example.demo.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.controller.SchoolStafController;
import com.example.demo.exceptions.SchoolStafExceptions;
import com.example.demo.model.Student;
import com.example.demo.model.UserApplication;
import com.example.demo.serviceImpl.SchoolStafServiceImpl;


@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class SchoolStafControllerTest {
	
	
//	 @Autowired 
//	 private MockMvc mvc;

	@InjectMocks
	private SchoolStafController schoolStafController;

	@MockBean
	private SchoolStafServiceImpl schoolStafServiceImpl;

//	@Test
//	public void testGetAllStudentList() throws SchoolStafExceptions {
//		List<Student> students = new ArrayList<>();
//		Student student = new Student();
//		student.setRegisterId("R0-10");
//		student.setZipCode(897836);
//		students.add(student);
//		when(schoolStafServiceImpl.findAll()).thenReturn(students);
//		List<Student> actualStudentList = schoolStafController.getAllStudentList();
//		assertEquals(actualStudentList, students);
//	}

	@Test
	public void testSetStudentStatus() throws SchoolStafExceptions {
		UserApplication userApplication = new UserApplication();
		userApplication.setUserName("siva@cognizant.com");
		Student student = new Student();
		student.setRegisterId("R0-10");
		//student.setStatus("Approve");
		student.setZipCode(897836);
		userApplication.setStudent(student);
		
	
		schoolStafServiceImpl.setStudentStatus(2, "Approve");
		ResponseEntity<String> actualStudentList = schoolStafController.studentStatus(1, "Approve");
		assertEquals("Status Updated SucessFully", actualStudentList.getBody());
	}

	@Test
	public void testStudentNote() throws SchoolStafExceptions {
		schoolStafServiceImpl.setStudentStatus(3, "Approve");
		ResponseEntity<String> actualMessage = schoolStafController.updateCircular("Session at 2 O clock");
		assertEquals("Circular Updated Sucefully", actualMessage.getBody());
	}

}
