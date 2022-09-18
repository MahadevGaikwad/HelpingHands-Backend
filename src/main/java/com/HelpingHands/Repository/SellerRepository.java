package com.HelpingHands.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HelpingHands.Entity.Seller;



@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {
	
	com.HelpingHands.Entity.Seller findByEmail(String email);

	

}
