package com.HelpingHands.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HelpingHands.DAO.SellerService;
import com.HelpingHands.DTO.LoginDTO;
import com.HelpingHands.DTO.Response;
import com.HelpingHands.Entity.Seller;




@CrossOrigin
@RestController
@RequestMapping("/api/sellers")
public class SellerController {

	@Autowired 
	private SellerService sellerService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Seller seller) {		
		try{
			sellerService.registerSeller(seller);
		
		return Response.success(seller);
		}
		catch(Exception e) {
			return Response.error(seller);
		}
	}
	
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		Seller user=sellerService.validate(dto.getEmail(),dto.getPwd());
		if(user!=null)
			return Response.success(user);
		else
			return Response.status(HttpStatus.NOT_FOUND);

	
	}
	@GetMapping("{id}")
	public ResponseEntity<?> findSellerProfile(@PathVariable("id") int id) {
		Seller result = sellerService.findById(id);
		return Response.success(result);
	}
	
}
