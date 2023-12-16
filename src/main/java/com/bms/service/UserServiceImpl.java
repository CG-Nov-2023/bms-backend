package com.bms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dao.UserRepository;
import com.bms.dao.entity.RolesEntity;
import com.bms.dao.entity.UserEntity;
import com.bms.model.AuthPojo;
import com.bms.model.RolesPojo;
import com.bms.model.UserPojo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JwtService jwtService;
	
	@Override
	public AuthPojo authenticateUser(UserPojo userPojo) {
		AuthPojo authPojo = new AuthPojo();
		UserEntity fetchedUserEntity = userRepository.findByUserName(userPojo.getUserName());
		if(fetchedUserEntity!=null && fetchedUserEntity.getUserPassword().equals(userPojo.getUserPassword())) {
			// means a record has been fetched
			// also password has matched
			// now copy the collection of roles entity into coleection of roles pojo
			List<RolesPojo> allRolesPojo = new ArrayList();
			for(RolesEntity eachRolesEntity: fetchedUserEntity.getAllRolesEntity()) {
				allRolesPojo.add(new RolesPojo(eachRolesEntity.getRolesId(), eachRolesEntity.getRolesName()));		
			}
			userPojo.setAllRolesPojo(allRolesPojo);
			authPojo.setUser(userPojo);
			authPojo.setToken(jwtService.generateToken(userPojo));
		}else {
			// username/password does not exist
			// throw custom exception
			throw new RuntimeException("Invalid Username/password!");
		}
		return authPojo;
	}

}
