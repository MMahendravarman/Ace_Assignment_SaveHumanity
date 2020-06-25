package com.hcl.blooddonorws.service.impl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.blooddonorws.data.BloodDonorsEntity;
import com.hcl.blooddonorws.data.BloodDonorsRepository;
import com.hcl.blooddonorws.data.UserDetails;
import com.hcl.blooddonorws.data.UserWSClient;
import com.hcl.blooddonorws.model.BloodDonorDTO;
import com.hcl.blooddonorws.service.BloodDonorService;


@Service
public class BloodDonorServiceImpl implements BloodDonorService{


	@Autowired
	UserWSClient userWSClient;

	@Autowired
	BloodDonorsRepository repository;

	@Override
	public void regAsBloodDonor(String userId,String token) {
		
		System.out.println(userId);
		UserDetails user = userWSClient.getUserDetails(userId,token);

		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		BloodDonorsEntity entity = mapper.map(user, BloodDonorsEntity.class);

		repository.save(entity);


	}

	public BloodDonorDTO getAllDonors() {
		Iterable<BloodDonorsEntity> entities = repository.findAll();
		
		BloodDonorDTO donor = new BloodDonorDTO();
		
		ArrayList<String> emailList = new ArrayList<String>();
		
		for(BloodDonorsEntity entity:entities) {
			emailList.add(entity.getEmail());
		}
		
		donor.setEmailList(emailList);
		return donor;
	}

}
