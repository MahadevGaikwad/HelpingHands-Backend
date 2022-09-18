package com.HelpingHands.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HelpingHands.DAO.ConsumerService;
import com.HelpingHands.DTO.LoginDTO;
import com.HelpingHands.DTO.Response;
import com.HelpingHands.Entity.Consumer;

import io.swagger.annotations.ApiOperation;



@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class ConsumerController {
	
	@Autowired(required=false)
	private ConsumerService customerService;
	
	@PostMapping
	@ApiOperation(value="Save a customer details",response = Consumer.class)
	public ResponseEntity<?> save(@RequestBody Consumer cust) {		
	try {	customerService.registerConsumer(cust);
		return Response.success(cust);
	}
	
	catch(Exception e) {
		
		return Response.error(e);
	}
	}
	
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		Consumer user=customerService.validate(dto.getEmail(),dto.getPwd());
		if(user!=null)
			return Response.success(user);
		else
			return Response.status(HttpStatus.NOT_FOUND);
	}
	


}
