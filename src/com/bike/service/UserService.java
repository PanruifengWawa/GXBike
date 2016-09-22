package com.bike.service;

import com.bike.utils.DataWrapper;

public interface UserService {
	DataWrapper<String> login(String userName,String password);

}
