package com.HelpingHands.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HelpingHands.Entity.Consumer;
import com.HelpingHands.Repository.ConsumerRepository;



@Service
public class ConsumerServiceImpl implements ConsumerService {
	
	@Autowired private ConsumerRepository dao;

	@Override
	public void registerConsumer(Consumer cust) {
		
		dao.save(cust);
	}

	@Override
	public Consumer validate(String email, String pwd) {
		Consumer cc=dao.findByEmail(email);
		if(cc!=null && cc.getPwd().equals(pwd)) {
			return cc;
		}
		return null;
	}

	@Override
	public void updateProfile(Consumer cust) {
		if(cust.getPwd().equals("") || cust.getPwd()==null) {
			cust.setPwd(findById(cust.getId()).getPwd());
		}
		dao.save(cust);	
		
		
	}

	@Override
	public Consumer findById(int id) {
		return dao.getById(id);
	}
	

	

	
	
	

	
	
}
