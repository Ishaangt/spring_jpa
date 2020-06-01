package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.UserEntity;
import com.example.model.UserRequest;
import com.example.model.UserResponse;
import com.example.service.UserService;

@RestController
public class OneController {

	@Autowired
	private UserService userSrv;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserRequest user) throws Exception {
		UserEntity userEn = userSrv.save(user);
		UserResponse resp = new UserResponse(((userEn.getId() != 0)?"Success":"Error"), "User Id " + userEn.getId() + " created", "");
		return ResponseEntity.ok(resp);
	}
}
