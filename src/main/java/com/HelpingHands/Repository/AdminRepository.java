package com.HelpingHands.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HelpingHands.Entity.Admin;



@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

	
}
