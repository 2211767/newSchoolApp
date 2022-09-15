package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.User;
import com.example.demo.exceptions.SchoolStafExceptions;

@RestController
@RequestMapping("/api/school")
public class AuthorizationController {

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) throws SchoolStafExceptions {
		RestTemplate rest = new RestTemplate();

		return rest.postForEntity("http://localhost:5005/api/user/v1/loginUser", user, Object.class);
	}

}
