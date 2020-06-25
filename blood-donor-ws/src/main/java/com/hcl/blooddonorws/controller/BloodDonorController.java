package com.hcl.blooddonorws.controller;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hcl.blooddonorws.model.BloodDonorDTO;

import com.hcl.blooddonorws.service.BloodDonorService;


@RestController
@RequestMapping("/bloodDonor")
public class BloodDonorController {

	@Autowired
	BloodDonorService bloodDonorSvc;
	
	@PostMapping("/{userId}/register")
	public void regAsBloodDonor(@PathVariable String userId,@RequestHeader("Authorization") String token) {
		System.out.println("inside blood donor controller");
		 bloodDonorSvc.regAsBloodDonor(userId,token);
		
	}
	
	@GetMapping("/getAll")
	public ArrayList<String> getAllDonors() {
		BloodDonorDTO donor= bloodDonorSvc.getAllDonors();
		
		//ModelMapper mapper = new ModelMapper();
		//mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		//GetAllDonorResponseModel donors = mapper.map(donor, GetAllDonorResponseModel.class);
		
		return donor.getEmailList();
	}
}
