package com.HelpingHands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.HelpingHands.DAO.AdminService;
import com.HelpingHands.Entity.Admin;
@SpringBootApplication
@EnableJpaAuditing
public class HelpingHandsBackend1Application {
	private static final Logger log = LoggerFactory.getLogger(HelpingHandsBackend1Application.class);
	

	public static void main(String[] args) {
		SpringApplication.run(HelpingHandsBackend1Application.class, args);
	}
	@Bean
	public CommandLineRunner demo(AdminService srv) {
	    return (args) -> {
	    	if(srv.countAdmin()==0) {
	    		Admin admin=new Admin();
	    		
	    		admin.setEmail("admin@gmail.com");
	    		admin.setPwd("admin");
	    		admin.setUname("Administrator");
	    		srv.updateAdmin(admin);
	    		log.info("Admin user created successfully");
	    	}
	    };
	}
}
