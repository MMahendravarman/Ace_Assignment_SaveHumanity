package com.hcl.userregistrationws.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.userregistrationws.model.CreateUserRequestModel;
import com.hcl.userregistrationws.model.CreateUserResponseModel;
import com.hcl.userregistrationws.model.UserDTO;
import com.hcl.userregistrationws.model.UserDetails;
import com.hcl.userregistrationws.service.UsersService;

@RestController
@RequestMapping("/users")
public class UserRegistrationController {
	
	@Autowired
	UsersService usersSvc;
	
	@PostMapping(
			consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			path = "/register"
	)
	public ResponseEntity<CreateUserResponseModel> userRegister(@Valid @RequestBody CreateUserRequestModel user) {
		
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		
		UserDTO createUser = mapper.map(user, UserDTO.class);
		UserDTO createdUser = usersSvc.createUser(createUser);
		CreateUserResponseModel response = mapper.map(createdUser, CreateUserResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	
	/*
	 * @PostMapping("/login") public String userLogin() { return "Working"; }
	 */
	
	@GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			path="/{userId}/details")
	public UserDetails getUserDetails(@PathVariable String userId) {
		System.out.println(userId);
		UserDetails user ;
		user = usersSvc.getUserDetails(userId);
		return user;
	}
}
