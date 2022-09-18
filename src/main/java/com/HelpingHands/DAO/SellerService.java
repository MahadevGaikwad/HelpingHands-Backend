package com.HelpingHands.DAO;

import java.util.List;

import com.HelpingHands.Entity.Seller;


public interface SellerService {
	void registerSeller(Seller seller);
	Seller validate(String email,String pwd);
	Seller findById(int id);
	
	
}
