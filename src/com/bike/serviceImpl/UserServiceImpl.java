package com.bike.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bike.dao.TokenDao;
import com.bike.dao.UserDao;
import com.bike.enums.ErrorCodeEnum;
import com.bike.models.Token;
import com.bike.models.User;
import com.bike.service.UserService;
import com.bike.utils.DataWrapper;
import com.bike.utils.MD5Util;


@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	@Autowired
	TokenDao tokenDao;

	@Override
	public DataWrapper<String> login(String userName, String password) {
		// TODO Auto-generated method stub
		DataWrapper<String> dataWrapper = new DataWrapper<String>();
		User user = userDao.getByUserName(userName);
		if (user != null && user.getPassword().equals(password) ) {
			Token token = tokenDao.getByUserId(user.getId());
			if(token == null) {
				token = new Token();
				token.setUserId(user.getId());
				String tokenString = MD5Util.getMD5String(user.getId() + user.getUserName() + user.getPassword() + new java.util.Date() );
				token.setToken(tokenString);
				if(tokenDao.addToken(token)) {
					dataWrapper.setData(tokenString);
				} else {
					dataWrapper.setErrorCode(ErrorCodeEnum.INNER_ERROR);
				}
				
			} else {
				String tokenString = MD5Util.getMD5String(user.getId() + user.getUserName() + user.getPassword() + new java.util.Date() );
				token.setToken(tokenString);
				if (tokenDao.updateToken(token)) {
					dataWrapper.setData(tokenString);
				} else {
					dataWrapper.setErrorCode(ErrorCodeEnum.INNER_ERROR);
				}
				
			}
		} else {
			dataWrapper.setErrorCode(ErrorCodeEnum.AUTH_ERROR);
		}
		return dataWrapper;
	}

}
