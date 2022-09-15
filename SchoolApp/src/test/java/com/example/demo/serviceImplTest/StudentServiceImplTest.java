package com.example.demo.serviceImplTest;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.exceptions.StudentExceptions;
import com.example.demo.model.Student;
import com.example.demo.model.UserApplication;
import com.example.demo.repository.CircularRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.serviceImpl.StudentServiceImpl;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {

	@InjectMocks
	private StudentServiceImpl studentServiceImpl;

	@MockBean
	private StudentRepository studentRepository;

	@MockBean
	CircularRepository circularRepository;

	@Test
	public void testSave() throws StudentExceptions {

		UserApplication userApplication = new UserApplication();
		Student student = new Student();
		student.setRegisterId("R-001");
		userApplication.setStudent(student);

		when(studentRepository.save(student)).thenReturn(student);

		student.setSecondoryContactPersonMobileNo("7036144");

		StudentExceptions secondaryMobileExce = Assertions.assertThrows(StudentExceptions.class, () -> {
			studentServiceImpl.save(userApplication, userApplication.getUserName());
		});
		Assertions.assertEquals("Secondary Contact Number should be 10 digits ", secondaryMobileExce.getMessage());

	
		student.setSecondoryContactPersonMobileNo("7036144732");
		student.setPrimaryContactPersonMobileNo("8008677");
		StudentExceptions primaryMobileExce = Assertions.assertThrows(StudentExceptions.class, () -> {
			studentServiceImpl.save(userApplication, userApplication.getUserName());
		});
		Assertions.assertEquals("Primary Contact Number should be 10 digits ", primaryMobileExce.getMessage());

	}

	@Test
	public void testUpdateStudent() throws StudentExceptions {

		UserApplication userApplication = new UserApplication();
		Student student = new Student();

		student.setRegisterId("R-001");
		student.setSecondoryContactPersonMobileNo("70361447");
		student.setPrimaryContactPersonMobileNo("8008677042");
		userApplication.setStudent(student);
		StudentExceptions contactNumberExce = Assertions.assertThrows(StudentExceptions.class, () -> {
			studentServiceImpl.updateStudent(userApplication);
		});
		Assertions.assertEquals("Contact Number should be 10 digits ", contactNumberExce.getMessage());

	}

}
