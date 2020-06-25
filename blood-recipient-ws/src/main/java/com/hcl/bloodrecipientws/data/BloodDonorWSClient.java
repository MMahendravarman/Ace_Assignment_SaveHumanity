package com.hcl.bloodrecipientws.data;

import java.util.ArrayList;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="blood-donor-ws",fallback = BloodDonorWSFallback.class)
public interface BloodDonorWSClient {

	@GetMapping("/bloodDonor/getAll")
	public ArrayList<String> getAllDonors();
}

@Component
class BloodDonorWSFallback implements BloodDonorWSClient{

	@Override
	public ArrayList<String> getAllDonors() {
		// TODO Auto-generated method stub
		return new ArrayList<String>();
	}
	
}