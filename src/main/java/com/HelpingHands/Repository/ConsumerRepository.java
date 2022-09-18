package com.HelpingHands.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HelpingHands.Entity.Consumer;



@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {
	
	com.HelpingHands.Entity.Consumer findByEmail(String email);

	
}
