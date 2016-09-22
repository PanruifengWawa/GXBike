package com.bike.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bike.dao.BikeDao;
import com.bike.dao.TokenDao;
import com.bike.enums.ErrorCodeEnum;
import com.bike.models.Bike;
import com.bike.models.Token;
import com.bike.service.BikeService;
import com.bike.utils.DataWrapper;



@Service("bikeService")
public class BikeServiceImpl implements BikeService {
	@Autowired
	TokenDao tokenDao;
	@Autowired
	BikeDao bikeDao;
	

	@Override
	public DataWrapper<Bike> getByCode(Long code,String tokenString) {
		// TODO Auto-generated method stub
		Token token = tokenDao.getByToken(tokenString);
		DataWrapper<Bike> dataWrapper = new DataWrapper<Bike>();
		if (token != null) {
			Bike bike = bikeDao.getByCode(code);
			dataWrapper.setData(bike);
		} else {
			dataWrapper.setErrorCode(ErrorCodeEnum.AUTH_ERROR);
		}
		return dataWrapper;
	}

}
