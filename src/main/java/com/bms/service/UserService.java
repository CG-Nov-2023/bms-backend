package com.bms.service;

import com.bms.model.AuthPojo;
import com.bms.model.UserPojo;

public interface UserService {
	AuthPojo authenticateUser(UserPojo userPojo);
}
