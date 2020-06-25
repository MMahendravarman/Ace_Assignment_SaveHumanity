package com.hcl.bloodrecipientws.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hcl.bloodrecipientws.model.BloodRequirementDetails;
import com.hcl.bloodrecipientws.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender javaMailSender;


	@Override
	public void sendEmail(BloodRequirementDetails details, ArrayList<String> emailList) {
		
		StringBuffer emailBody = new StringBuffer();
		emailBody.append("Required Blood Group:");
		emailBody.append(details.getBloodType());
		emailBody.append("\n");
		emailBody.append("Contact Number:");
		emailBody.append(details.getContactNum());
		SimpleMailMessage mail = new SimpleMailMessage();
		String[] emails = new String[emailList.size()];
		for(int i=0;i<emailList.size();i++)
		{
			emails[i]=emailList.get(i);
		}
		mail.setBcc(emails);
		mail.setSubject("Urgent - Blood Donor Needed!");
		mail.setText(emailBody.toString());
		javaMailSender.send(mail);
		
		
	}

}
