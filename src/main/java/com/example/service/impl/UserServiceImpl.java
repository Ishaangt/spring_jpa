package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.entity.ParentRoleUser;
import com.example.entity.RoleUser;
import com.example.entity.UserEntity;
import com.example.model.ParentRoleUserModel;
import com.example.model.SubRoleUserModel;
import com.example.model.UserRequest;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserEntity save(UserRequest request) throws Exception {
		UserEntity user = new UserEntity();
		ParentRoleUser parent = null;
		RoleUser subrole = null;
		List<RoleUser> subroleList = new ArrayList<RoleUser>();
		List<ParentRoleUser> parentList = new ArrayList<ParentRoleUser>();
		
		user.setUsername(request.getUsername());
		user.setPassword(request.getPassword());
//		parent.setParentRole(request.getParent().getParent_role());
//		parent.setSubroles(subroleList);
		for(ParentRoleUserModel model : request.getParent()) {
			parent = new ParentRoleUser();
			parent.setParentRole(model.getParent_role());
			parent.setUser(user);
			for(SubRoleUserModel submodel : model.getSub_roles()) {
				subrole = new RoleUser();
				subrole.setRole(submodel.getRole());
				subrole.setParentRoles(parent);
				subroleList.add(subrole);
			}
			parent.setSubroles(subroleList);
			parentList.add(parent);
		}
		user.setParent(parentList);
		return userDao.save(user);
	}

	
}
