package com.hcl.blooddonorws.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="blooddonors")
public class BloodDonorsEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3266034786601950229L;

	@Column(nullable = false,unique=true,length=120)
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	@Id
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
