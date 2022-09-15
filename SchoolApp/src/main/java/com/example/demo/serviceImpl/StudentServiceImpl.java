package com.example.demo.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.SchoolStafExceptions;
import com.example.demo.exceptions.StudentExceptions;
import com.example.demo.model.Circular;
import com.example.demo.model.Student;
import com.example.demo.model.UserApplication;
import com.example.demo.repository.CircularRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UserApplicationRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private static final Logger logger = LoggerFactory.getLogger(SchoolStafServiceImpl.class);

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	CircularRepository circularRepository;

	@Autowired
	UserApplicationRepository userApplicationRepository;

	@Override
	public UserApplication save(UserApplication userApp, String userName) throws StudentExceptions {
		Student student = userApp.getStudent();
		if (student.getSecondoryContactPersonMobileNo().toString().length() == 10) {
			if (student.getPrimaryContactPersonMobileNo().toString().length() == 10) {
				student.setCreatedDate(LocalDateTime.now());
				student.setUpdatedDate(LocalDateTime.now());
				logger.info("Student Details Saved to Db");
				userApp.setUserName(userName);
				return userApplicationRepository.save(userApp);
			} else {
				logger.error("Primary Contact Number should be 10 digits ");
				throw new StudentExceptions("Primary Contact Number should be 10 digits ");
			}
		} else {
			logger.error("Secondary Contact Number should be 10 digits ");
			throw new StudentExceptions("Secondary Contact Number should be 10 digits ");
		}

	}

	@Override
	public void updateStudent(UserApplication userApplication) throws StudentExceptions {
		Student student = userApplication.getStudent();
		if (student.getRegisterId() != null) {
			if (student.getSecondoryContactPersonMobileNo().toString().length() == 10
					&& student.getPrimaryContactPersonMobileNo().toString().length() == 10) {
				student.setUpdatedDate(LocalDateTime.now());
				logger.info("Student Details Updated to Db");
				userApplicationRepository.save(userApplication);
			} else {
				logger.error("Contact Number should be 10 digits ");
				throw new StudentExceptions("Contact Number should be 10 digits ");
			}

		} else {
			logger.error("Student Details Not Present to Update");
			throw new StudentExceptions("Student Details Not Present to Update");
		}

	}

	@Override
	public UserApplication findByName(String email) throws StudentExceptions {
		UserApplication student = userApplicationRepository.findByUserName(email);
		logger.info("Started findByEmailAddres function with Email " + email);
		if (student != null) {
			return student;
		} else {
			logger.error("Student Details Not Present with These Email: " + email);
			throw new StudentExceptions("Student Details Not Present with These Email: " + email);
		}

	}

	@Override
	public void acknowldgeStatus(Integer circularId, String acknowldgeStatus) throws StudentExceptions {
		Circular circular1 = circularRepository.findByCircularId(circularId);
		logger.info("Started findById function with circularId " + circularId);

		if (circular1 != null && circular1.getCircular() != null) {
			circular1.setAcknowledge(acknowldgeStatus);
			circular1.setAcknowldgeAcceptedDate(LocalDateTime.now());
			logger.info("AcknowldgeStatus Added Sucessfully In Db");
			circularRepository.save(circular1);
		} else {
			logger.error(" Circular Details Not Fund with Id: " + circularId);
			throw new StudentExceptions("Circular Details Not Fund with Id: " + circularId);
		}

	}
	
	@Override
	public List<Student> findAll() throws StudentExceptions {
		List<Student> studentList = (List<Student>) studentRepository.findAll();
		logger.info("Find All Student Function called");
		if (studentList != null) {
			return studentList;
		} else {
			logger.error("No Student Details Fund");
			throw new StudentExceptions("No Student Details Fund");
		}
	}

//	@Override
//	public void acknowldgeStatus(String registerId, String acknowldgeStatus) throws StudentExceptions {
//		Optional<Student> student = studentRepository.findByRegisterId(registerId);
//		Student studentStatus = student.get();
//		if (studentStatus != null && studentStatus.getRegisterId() != null) {
//			studentStatus.setAcknowldgeStatus(acknowldgeStatus);
//			studentRepository.save(studentStatus);
//		} else {
//			throw new StudentExceptions("No Student Details Fund");
//		}
//
//	}

}
