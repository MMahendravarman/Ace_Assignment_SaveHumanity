package com.hcl.userregistrationws.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.hcl.userregistrationws.model.UserDTO;
import com.hcl.userregistrationws.model.UserDetails;


public interface UsersService extends UserDetailsService{

	public UserDetails getUserDetails(String userId);
	
	public UserDTO createUser(UserDTO user);
	
	public UserDTO getUserDetailsByUserName(String userName);
}
