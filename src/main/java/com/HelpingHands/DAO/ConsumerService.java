package com.HelpingHands.DAO;

import java.util.List;

import com.HelpingHands.Entity.Consumer;



public interface ConsumerService {
	void registerConsumer(Consumer cust);

	Consumer validate(String email,String pwd);
	void updateProfile(Consumer cust);
	Consumer findById(int id);
	
	
}
