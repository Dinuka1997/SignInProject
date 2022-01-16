package com.example.EmployeeSys.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeSys.model.User;
import com.example.EmployeeSys.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	RegistrationService service;
	
	@PostMapping("/registerUser")
	@CrossOrigin(origins = "http://localhost:4200/")
	public User registerUser(@RequestBody User user)throws Exception {
		String tempEmail = user.getEmailId();
		
		if(tempEmail != null && !tempEmail.isEmpty()) {
			User userObj =  service.fetchUserByUserEmailID(tempEmail);
			if(userObj != null) {
				throw new Exception("user with "+tempEmail+" is already exist");
			}
		}
		return service.saveUser(user);
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200/")
	public User loginUser(@RequestBody User user)throws Exception{
		String tempEmail = user.getEmailId();
		String tempPassword = user.getPassword();
		User userObj = null;
		
		if(tempEmail != null && tempPassword != null) {
			userObj =  service.fetchUserByUserEmailIDAndPassword(tempEmail, tempPassword);
		}
		if(userObj == null) {
			throw new Exception("Bad credentials");
		}
		return userObj;
	}
}
