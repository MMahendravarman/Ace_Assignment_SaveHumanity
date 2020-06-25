package com.hcl.blooddonorws.data;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;



@FeignClient(name="user-registration-ws",fallback = UsersRegWSFallback.class)

public interface UserWSClient {

	@GetMapping(path="/users/{userId}/details")
	public UserDetails getUserDetails(@PathVariable String userId,@RequestHeader("Authorization") String token);
		
	
}

@Component
class UsersRegWSFallback implements UserWSClient{

	@Override
	public UserDetails getUserDetails(String userId,String token) {
		// TODO Auto-generated method stub
		return new UserDetails();
	}
	
}
