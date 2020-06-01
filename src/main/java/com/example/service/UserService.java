package com.example.service;

import com.example.entity.UserEntity;
import com.example.model.UserRequest;

public interface UserService {

	UserEntity save(UserRequest request) throws Exception;
}
