package com.bms.service;

import com.bms.model.UserPojo;

public interface UserService {
	UserPojo authenticateUser(UserPojo userPojo);
}
