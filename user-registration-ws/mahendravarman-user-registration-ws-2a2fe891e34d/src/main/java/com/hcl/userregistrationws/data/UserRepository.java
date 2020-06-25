package com.hcl.userregistrationws.data;



import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String>{

	UserEntity findByUserName(String userName);

}
