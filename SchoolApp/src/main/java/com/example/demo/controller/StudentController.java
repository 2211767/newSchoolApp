package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.SchoolStafExceptions;
import com.example.demo.exceptions.StudentExceptions;
import com.example.demo.filter.JwtTokenUtil;
import com.example.demo.model.Student;
import com.example.demo.model.UserApplication;
import com.example.demo.service.StudentService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class StudentController {
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@PostMapping("/registerStudent")
	public ResponseEntity<UserApplication> registerStudent(@RequestBody UserApplication userApplication,@RequestHeader(name = "Authorization") String token) throws StudentExceptions {
		logger.info("RegisterStudent Method Called");
		String username1 = jwtTokenUtil.getUsernameFromToken(token);
		return new ResponseEntity<UserApplication>(studentService.save(userApplication,username1), HttpStatus.OK);
	}

	@PutMapping("/studentAcknowledge/{circularId}/{acknowldgeStatus}")
	public ResponseEntity<String> acknowldgeStatus(@PathVariable Integer circularId,
			@PathVariable String acknowldgeStatus) throws StudentExceptions {
		logger.info("StudentAcknowledge Method Called with CircularId" + circularId);
		studentService.acknowldgeStatus(circularId, acknowldgeStatus);
		logger.info("StudentAcknowledge Method Ended");
		return new ResponseEntity<String>("Student AcknowldgeStatus Updated SucessFully", HttpStatus.OK);
	}

	@GetMapping("/getStudentDetails")
	public UserApplication getStudentDetails(@RequestHeader(name = "Authorization") String token)
			throws StudentExceptions, IOException, ServletException {
		String username1 = jwtTokenUtil.getUsernameFromToken(token);
		return studentService.findByName(username1);
	}

	@PutMapping("/updateStudent")
	public ResponseEntity<String> updateStudent(@RequestBody UserApplication userApplication) throws StudentExceptions {
		logger.info("Update Student Function Called");
		studentService.updateStudent(userApplication);
		logger.info("Update Student Function Ended");
		return new ResponseEntity<String>("Student Details Updated SucessFully", HttpStatus.OK);
	}
	
	@GetMapping("/getAllStudentList")
	public List<Student> getAllStudentList() throws StudentExceptions {
		logger.info("Started  getAllStudentList Method");
		return studentService.findAll();
	}

}
