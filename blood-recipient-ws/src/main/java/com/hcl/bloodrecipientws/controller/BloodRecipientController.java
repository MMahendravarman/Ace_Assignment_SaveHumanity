package com.hcl.bloodrecipientws.controller;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bloodrecipientws.model.BloodRequirementDetails;
import com.hcl.bloodrecipientws.model.BloodRequirementDetailsDTO;
import com.hcl.bloodrecipientws.service.BloodRecipientService;
import com.hcl.bloodrecipientws.service.EmailService;


@RestController
@RequestMapping("/bloodrecipient")
public class BloodRecipientController {

	@Autowired
	BloodRecipientService bloodRecipientSvc;
	
	@Autowired
	EmailService mailService;
	
	
	@PostMapping(
			consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			path = "/{userId}/requirement"
	)	
	public void postBloodRequirement(@RequestBody BloodRequirementDetails details,@PathVariable String userId) {
		
		
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		
		BloodRequirementDetailsDTO bloodRequirementDTO = mapper.map(details, BloodRequirementDetailsDTO.class);
		bloodRequirementDTO.setUserId(userId);
		ArrayList<String> emailList = bloodRecipientSvc.postBloodRequirement(bloodRequirementDTO);
		mailService.sendEmail(details,emailList);
	}
	
	
}
