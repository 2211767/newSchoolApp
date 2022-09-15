package com.example.demo.serviceImplTest;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.exceptions.SchoolStafExceptions;
import com.example.demo.model.Student;
import com.example.demo.repository.CircularRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.serviceImpl.SchoolStafServiceImpl;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class SchoolStafServiceImplTest {
 
	@InjectMocks
	private SchoolStafServiceImpl schoolStafServiceImpl;

	@MockBean
	private StudentRepository studentRepository;

	@MockBean
	CircularRepository circularRepository;

	

	@Test
	public void testSetStudentStatus() throws SchoolStafExceptions {
		Student student = new Student();
		student.setRegisterId("R0-10");
		//student.setStatus("Approve");
//		when(studentRepository.findByRegisterId("R0-10")).thenReturn(student);
//		SchoolStafExceptions actualException = Assertions.assertThrows(SchoolStafExceptions.class, () -> {
//			schoolStafServiceImpl.setStudentStatus("R0-1", "Approve");
//		});
//		Assertions.assertEquals("Student Details Not Fund with RegisterId: " + "R0-1", actualException.getMessage());

	}

	@Test
	public void testSetCircular() throws SchoolStafExceptions {
		List<Student> students = new ArrayList<>();
		Student student = new Student();
		student.setRegisterId("R0-10");
		students.add(student);
		when(studentRepository.findAll()).thenReturn(students);

		when(studentRepository.findAll()).thenReturn(null);
		SchoolStafExceptions actualException = Assertions.assertThrows(SchoolStafExceptions.class, () -> {
			schoolStafServiceImpl.setCircular("Session at 2 o clock");
		});
		Assertions.assertEquals("Student Details Not Fund", actualException.getMessage());

	}

}
