package com.bike.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bike.models.Bike;
import com.bike.service.BikeService;
import com.bike.utils.DataWrapper;

@Controller
@RequestMapping(value="api/bike")
public class BikeController {
	@Autowired
	BikeService bikeService;
	
	@RequestMapping(value="/getByCode", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Bike> getByCode(
    		@RequestParam(value = "code", required = true) Long code,
    		@RequestHeader(value = "token", required = true) String token) {
        return bikeService.getByCode(code,token);
    }
}
