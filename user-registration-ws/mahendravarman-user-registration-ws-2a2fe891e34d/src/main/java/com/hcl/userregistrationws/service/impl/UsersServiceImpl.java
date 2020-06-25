package com.hcl.userregistrationws.service.impl;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hcl.userregistrationws.data.UserEntity;
import com.hcl.userregistrationws.data.UserRepository;
import com.hcl.userregistrationws.model.UserDTO;
import com.hcl.userregistrationws.model.UserDetails;
import com.hcl.userregistrationws.service.UsersService;


@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails getUserDetails(String userId) {
		// TODO Auto-generated method stub
		
		Optional<UserEntity> entity = userRepository.findById(userId);
		UserEntity userEntity= entity.get();
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserDetails userDTO = mapper.map(userEntity, UserDetails.class);
		return userDTO;
	}

	@Override
	public UserDTO createUser(UserDTO user) {
		// TODO Auto-generated method stub
		
		user.setUserId(UUID.randomUUID().toString());
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserEntity entity = mapper.map(user, UserEntity.class);
		entity.setEncryptedPwd(bCryptPasswordEncoder.encode(user.getPassword()));
		
		userRepository.save(entity);
		
		UserDTO returnUser = mapper.map(entity,UserDTO.class);
		return returnUser;
	}

	@Override
	public UserDTO getUserDetailsByUserName(String userName) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findByUserName(userName);
		//UserEntity userEntity= entity.
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserDTO userDTO = mapper.map(userEntity, UserDTO.class);
		return userDTO;
	}

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findByUserName(username);
		
		if(userEntity == null) throw new UsernameNotFoundException(username);	
		
		return new User(userEntity.getUserName(), userEntity.getEncryptedPwd(), true, true, true, true, new ArrayList<>());
	}

}
