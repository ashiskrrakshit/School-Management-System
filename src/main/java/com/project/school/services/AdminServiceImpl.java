package com.project.school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.school.entities.User;
import com.project.school.enums.UserRole;
import com.project.school.repositories.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class AdminServiceImpl {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void createAdminAccount() {
		
		User existingAdmin = userRepository.findByRole(UserRole.ADMIN);
		
		if(existingAdmin == null) {
		User adminAccount = new User();
		adminAccount.setEmail("admin@test.com");
		adminAccount.setName("admin");
		adminAccount.setRole(UserRole.ADMIN);
		adminAccount.setPassword(new BCryptPasswordEncoder().encode("admin"));
		userRepository.save(adminAccount);
	}
	}
}
