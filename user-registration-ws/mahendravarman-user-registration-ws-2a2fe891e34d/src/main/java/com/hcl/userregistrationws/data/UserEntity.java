package com.hcl.userregistrationws.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity implements Serializable
{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8587814272656918013L;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEncryptedPwd() {
		return encryptedPwd;
	}
	public void setEncryptedPwd(String encryptedPwd) {
		this.encryptedPwd = encryptedPwd;
	}
	@Column(nullable = false,unique=true,length=50)
	private String userName;
	@Column(nullable = false,unique=true,length=120)
	private String email;
	
	@Id
	private String userId;
	@Column(nullable = false)
	private String encryptedPwd;
}
