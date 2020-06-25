package com.hcl.userregistrationws.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {
	@NotNull(message="User name cannot be null")
	@Size(min=6,message="User name must not be less than six characters")
	private String userName;
	@NotNull(message="Email cannot be null")
	@Email
	private String email;
	@NotNull(message="Password cannot be null")
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
