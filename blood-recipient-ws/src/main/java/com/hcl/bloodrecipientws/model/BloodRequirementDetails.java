package com.hcl.bloodrecipientws.model;

import javax.validation.constraints.NotNull;

public class BloodRequirementDetails {
	
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	@NotNull(message="Blood Group type cannot be null")
	private String bloodType;
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	@NotNull(message="Contact number cannot be null")
	private String contactNum;

}
