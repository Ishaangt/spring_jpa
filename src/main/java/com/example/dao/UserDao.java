package com.example.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.UserEntity;

@Repository
public interface UserDao extends CrudRepository<UserEntity, Integer>{

}
