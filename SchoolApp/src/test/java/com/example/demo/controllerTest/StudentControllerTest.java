package com.example.demo.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.model.Student;
import com.example.demo.model.UserApplication;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentControllerTest.class)
public class StudentControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void registerStudent() throws Exception {
		UserApplication userApplication = new UserApplication();
		userApplication.setUserName("siva@cognizant.com");
		Student student = new Student();
		student.setRegisterId("R-001");
		student.setSecondoryContactPersonMobileNo("7036144732");
		student.setPrimaryContactPersonMobileNo("8008677042");
		userApplication.setStudent(student);
		mvc.perform(
				post("/registerStudent").contentType(MediaType.APPLICATION_JSON).
				content(asJsonString(userApplication)));	
	}

	public static String asJsonString(final UserApplication obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Test
	public void updateStudent() throws Exception {
		UserApplication userApplication = new UserApplication();
		Student student = new Student();
		student.setRegisterId("R-001");
		student.setSecondoryContactPersonMobileNo("7036144732");
		student.setPrimaryContactPersonMobileNo("8008677042");
		userApplication.setStudent(student);
		{

			mvc.perform(MockMvcRequestBuilders.put("/updateStudent").content(asJsonString(userApplication))
					.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
				
		}
	}

}
