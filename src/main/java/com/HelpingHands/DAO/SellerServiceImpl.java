package com.HelpingHands.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HelpingHands.Entity.Seller;
import com.HelpingHands.Repository.SellerRepository;


@Service
public class SellerServiceImpl implements SellerService {

	@Autowired private SellerRepository dao;
	@Override
	public void registerSeller(Seller seller) {
		// TODO Auto-generated method stub
		dao.save(seller);
	}
	
	@Override
	public Seller validate(String email, String pwd) {
		Seller seller=dao.findByEmail(email);
		if(seller!=null && seller.getPwd().equals(pwd)) {
			return seller;
		}
		return null;
	}

	@Override
	public Seller findById(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
		
	}



}
