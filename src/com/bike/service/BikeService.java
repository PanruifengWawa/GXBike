package com.bike.service;

import com.bike.models.Bike;
import com.bike.utils.DataWrapper;

public interface BikeService {
	DataWrapper<Bike> getByCode(Long code,String token);

}
