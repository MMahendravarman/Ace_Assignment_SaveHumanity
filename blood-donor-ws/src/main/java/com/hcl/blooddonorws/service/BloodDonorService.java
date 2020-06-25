package com.hcl.blooddonorws.service;


import com.hcl.blooddonorws.model.BloodDonorDTO;

public interface BloodDonorService {

	public void regAsBloodDonor(String userId,String token);
	
	public BloodDonorDTO getAllDonors();
	
}
