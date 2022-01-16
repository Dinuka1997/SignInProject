package com.example.EmployeeSys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeSys.model.User;
import com.example.EmployeeSys.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	RegistrationRepository repository;
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public User fetchUserByUserEmailID(String email_id) {
		return repository.findByEmailId(email_id);
	}
	
	public User fetchUserByUserEmailIDAndPassword(String emaii,String password) {
		return repository.findByEmailIdAndPassword(emaii, password);
	}

}
