package com.bike.dao;

import com.bike.models.Bike;

public interface BikeDao {
	Bike getByCode(Long code);
}
