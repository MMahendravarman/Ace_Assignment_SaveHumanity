package com.hcl.bloodrecipientws.service;

import java.util.ArrayList;


import com.hcl.bloodrecipientws.model.BloodRequirementDetailsDTO;

public interface BloodRecipientService {

	ArrayList<String> postBloodRequirement(BloodRequirementDetailsDTO details);

}
