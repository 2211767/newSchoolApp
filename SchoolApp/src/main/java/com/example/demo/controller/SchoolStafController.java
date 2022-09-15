package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.SchoolStafExceptions;
import com.example.demo.model.Student;
import com.example.demo.service.SchoolStafService;

import io.jsonwebtoken.Claims;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class SchoolStafController {
	private static final Logger logger = LoggerFactory.getLogger(SchoolStafController.class);

	@Autowired
	private SchoolStafService schoolStafService;

	
	@PutMapping("/studentStatus/{userId}/{status}")
	public ResponseEntity<String> studentStatus(@PathVariable Integer userId, @PathVariable String status)
			throws SchoolStafExceptions {
		logger.info("Started studentSatus Method with userId" + userId);
		schoolStafService.setStudentStatus(userId, status);
		logger.info("Call Ended studentSatus Method with userId" + userId);
		return new ResponseEntity<String>("Status Updated SucessFully", HttpStatus.OK);
	}

	@PutMapping("/studentNode/{circular}")
	public ResponseEntity<String> updateCircular(@PathVariable String circular) throws SchoolStafExceptions {
		logger.info("Circular Method Called");
		schoolStafService.setCircular(circular);
		logger.info(" Circular Method Ended");
		return new ResponseEntity<String>("Circular Updated Sucefully", HttpStatus.OK);
	}

}
