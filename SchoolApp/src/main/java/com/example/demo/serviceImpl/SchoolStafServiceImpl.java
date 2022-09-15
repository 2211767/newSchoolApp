package com.example.demo.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.SchoolStafExceptions;
import com.example.demo.model.Circular;
import com.example.demo.model.Student;
import com.example.demo.model.UserApplication;
import com.example.demo.repository.CircularRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UserApplicationRepository;
import com.example.demo.service.SchoolStafService;

@Service
public class SchoolStafServiceImpl implements SchoolStafService {

	private static final Logger logger = LoggerFactory.getLogger(SchoolStafServiceImpl.class);

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	CircularRepository circularRepository;

	@Autowired
	UserApplicationRepository userApplicationRepository;

	@Override
	public void setStudentStatus(Integer userId, String status) throws SchoolStafExceptions {
		// Student student = studentRepository.findByRegisterId(registerId);

		UserApplication userApp = userApplicationRepository.findByUserAppId(userId);
		logger.info("SetStudentStatus Function called");
		if (userApp != null) {
			// student.setStatus(status);
			logger.info("StudentStatus Details Saved");
			userApp.setStatus(status);
			userApplicationRepository.save(userApp);
		} else {
			logger.error("User Details Not Fund with UserId: " + userId);
			throw new SchoolStafExceptions("User Details Not Fund with UserId: " + userId);
		}
	}

	@Override
	public void setCircular(String circular1) throws SchoolStafExceptions {
		List<Student> studentList = (List<Student>) studentRepository.findAll();
		logger.info("Retrieve All Student Function called");
		if (studentList != null && !studentList.isEmpty()) {
			for (Student student : studentList) {
				Circular circular = new Circular();
				circular.setRegisterId(student.getRegisterId());
				circular.setCircular(circular1);
				circular.setCircularCreatedDate(LocalDateTime.now());
				logger.info("Circular Details Saved");
				circularRepository.save(circular);
			}

		} else {
			logger.error("Student Details Not Fund");
			throw new SchoolStafExceptions("Student Details Not Fund");
		}

	}

}
