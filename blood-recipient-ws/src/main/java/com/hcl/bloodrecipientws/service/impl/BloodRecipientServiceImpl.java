package com.hcl.bloodrecipientws.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bloodrecipientws.data.BloodDonorWSClient;
import com.hcl.bloodrecipientws.data.BloodRequirementEntity;
import com.hcl.bloodrecipientws.data.BloodRequirementRepository;
import com.hcl.bloodrecipientws.model.BloodRequirementDetailsDTO;
import com.hcl.bloodrecipientws.service.BloodRecipientService;



@Service
public class BloodRecipientServiceImpl implements BloodRecipientService{
	
	@Autowired	
	BloodDonorWSClient client;
	
	@Autowired
	BloodRequirementRepository repository;

	@Override
	public ArrayList<String> postBloodRequirement(BloodRequirementDetailsDTO details) {
		ArrayList<String> emailList = client.getAllDonors();
		
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		
		BloodRequirementEntity recipient = mapper.map(details, BloodRequirementEntity.class);
		
		repository.save(recipient);
		
		return emailList;
		
	}

}
