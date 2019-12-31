package com.emailchecker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emailchecker.model.EmailRequest;
import com.emailchecker.model.EmailResponse;
import com.emailchecker.service.EmailCheckerService;

@RestController(value = "EmailCheckerController")
public class EmailCheckerController {
	
	@Autowired EmailCheckerService emailCheckerService;

	@PostMapping(value = "/email/check", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> getEmailCount(@RequestBody EmailRequest emailRequest) {
		EmailResponse emailResponse = new EmailResponse();
		emailResponse.setCount(emailCheckerService.getUniqueEmail(emailRequest.getEmails()));
		return new ResponseEntity<>(emailResponse, HttpStatus.OK);

	}
}
