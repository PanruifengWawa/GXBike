package com.bike.dao;

import com.bike.models.User;

public interface UserDao {
	User getByUserName(String userName);

}
