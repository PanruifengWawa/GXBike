package com.bike.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bike.service.UserService;
import com.bike.utils.DataWrapper;

@Controller
@RequestMapping(value="api/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)//read
    @ResponseBody
    public DataWrapper<String> Login(
    		@RequestParam(value = "userName", required = true) String userName,
    		@RequestParam(value = "password", required = true) String password) {
        return userService.login(userName, password);
    }
}
