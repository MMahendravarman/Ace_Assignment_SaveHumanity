package com.hcl.bloodrecipientws.service;

import java.util.ArrayList;

import com.hcl.bloodrecipientws.model.BloodRequirementDetails;

public interface EmailService {

	public void sendEmail(BloodRequirementDetails details, ArrayList<String> emailList);
}
