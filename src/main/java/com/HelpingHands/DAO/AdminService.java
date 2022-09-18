package com.HelpingHands.DAO;

import com.HelpingHands.Entity.Admin;

public interface AdminService {
	Admin validate(String email,String pwd);
	void updateAdmin(Admin admin);
	long countAdmin();
}
